import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @Author Kevin
 * @Description rabbitmq demo 发送消息端
 * @Date 2019/4/30 11:27
 **/
public class Send {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "Hello World!"+System.currentTimeMillis();
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("Sent:" + message);
        channel.close();
        conn.close();
    }

}
