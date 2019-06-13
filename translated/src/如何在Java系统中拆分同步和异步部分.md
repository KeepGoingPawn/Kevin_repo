# 如何在Java系统中拆分同步和异步部分  

&nbsp;
原文链接:https://dzone.com/articles/how-to-split-up-a-synchronous-and-asynchronous-of
&nbsp;
[作者：Petr Bouda](https://github.com/petrbouda)
&nbsp;
[译者：KeepGoingPawn](https://blog.csdn.net/hengji666)
&nbsp;

## 1.了解如何使用Java通过同步和异步组件拆分系统

&nbsp;
很多开发人员说,将应用程序切换到异步处理很复杂。因为他们有一个天然需要同步通信的Web应用程序。在这篇文章中，我想介绍一种方法来达到异步通信的目的：使用一些众所周知的库和工具来设计他们的系统。 下面的例子是用Java编写的，但我相信它更多的是基本原理，同一个应用程序可以用任何语言来重新写。
&nbsp;
所需的工具和库:
&nbsp;

- Spring Boot
- RabbitMQ
  &nbsp;

## 2.Web 应用程序

&nbsp;
一个用Spring MVC编写的Web应用程序并运行在Tomcat上。 它所做的只是将一个字符串发送到一个队列中 (异步通信的开始) 并等待另一个队列中的消息作为HTTP响应发送回来。
&nbsp;
首先，我们需要定义几个依赖项，然后等待Spring Boot执行所有必要的自动配置。
&nbsp;

```java
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <dependency>
        <groupId>com.thedeanda</groupId>
        <artifactId>lorem</artifactId>
    </dependency>
</dependencies>
```

&nbsp;

```java
@SpringBootApplication
public class BlockingApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlockingApplication.class, args);
    }
    @RestController
    public static class MessageController {
        private final RabbitTemplate rabbitTemplate;
        public MessageController(CachingConnectionFactory connectionFactory) {
            this.rabbitTemplate = new RabbitTemplate(connectionFactory);
        }
        @GetMapping("invoke")
        public String sendMessage() {
            Message response = rabbitTemplate.sendAndReceive("uppercase", null, request());
            return new String(response.getBody());
        }
        private static Message request() {
            Lorem LOREM = LoremIpsum.getInstance();
            String name = LOREM.getFirstName() + " " + LOREM.getLastName();
            return new Message(name.getBytes(), new MessageProperties());
        }
    }
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setAddresses("localhost:5672");
        factory.setUsername("admin");
        factory.setPassword("admin");
        return factory;
    }
}
```

&nbsp;

## 3.消费端应用程序

&nbsp;
第二个应用程序仅仅是一个等待消息的RabbitMQ的消费端,将拿到的字符串转换为大写,然后将此结果发送到输出队列中。
&nbsp;

```java
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
</dependencies>
```

&nbsp;

```java
@SpringBootApplication
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
    public static class MessageListener {
        public String handleMessage(byte[] message) {
            Random rand = new Random();
            // Obtain a number between [0 - 49] + 50 = [50 - 99]
            int n = rand.nextInt(50) + 50;
            String content = new String(message);
            try {
                Thread.sleep(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return content.toUpperCase();
        }
    }
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setAddresses("localhost:5672");
        factory.setUsername("admin");
        factory.setPassword("admin");
        return factory;
    }
    @Bean
    public SimpleMessageListenerContainer serviceListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setConcurrentConsumers(20);
        container.setMaxConcurrentConsumers(40);
        container.setQueueNames("uppercase_messages");
        container.setMessageListener(new MessageListenerAdapter(new MessageListener()));
        return container;
    }
}
```

&nbsp;



### 4.如何在容器中运行的?

&nbsp;
程序启动并首次调用sendMessage()方法后，我们可以看到Spring AMQP支持自动创建了一个新的**回复队列**并等待来自我们的服务应用程序的响应。
&nbsp;

```
2019-05-12 17:23:21.451  INFO 4574 --- [nio-8080-exec-1] .l.DirectReplyToMessageListenerContainer : Container initialized for queues: [amq.rabbitmq.reply-to]
2019-05-12 17:23:21.457  INFO 4574 --- [nio-8080-exec-1] .l.DirectReplyToMessageListenerContainer : SimpleConsumer [queue=amq.rabbitmq.reply-to, consumerTag=amq.ctag-VF-iqD9rLEuljIBstbCI1A identity=10e58093] started
```

&nbsp;

如果我们在消费端应用程序中查看消息，我们可以看到Spring自动传播有关**回复队列**的信息以及**相关ID，**用于将其传递回Web应用程序以便能够将请求和响应配对在一起。
&nbsp;
这就是发生魔术的地方。 当然，如果您想使其更复杂，您可以在协作中包含更多服务，然后将Web应用程序的最终响应放入与自动生成的队列不同的队列中，该队列只具有正确的关联ID。 另外，不要忘记设置合理的超时。
&nbsp;
这个解决方案还有一个很大的缺点 - 应用程序吞吐量。 我故意这样做，以便我可以跟进这篇文章，进一步深入调查`AsyncProfiler`！ 但是目前，我们使用Tomcat作为主HTTP服务器，默认为200个线程，这意味着我们的应用程序无法同时处理200多条消息，因为我们的服务器线程正在等待RabbitMQ **回复队列**的响应，直到有消息进入或发生超时。
&nbsp;
感谢您阅读本文，敬请关注后续内容！ 如果您想自己尝试一下，请查看我的[GitHub存储库](https://github.com/petrbouda/rabbitmq-async-microservices)。 