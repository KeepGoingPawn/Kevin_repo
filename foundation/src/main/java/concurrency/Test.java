package concurrency;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author:Kevin
 * @Description: test volatile visiable
 * @Date: 2019/6/13 13:34
 */
public class Test {
    volatile Demo demo = new Demo("zzz");

    public static void main(String[] args) {
        Test t = new Test();
        new Thread(() -> t.gerName()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        t.demo.setName("zz");
    }

    private void gerName(){
        while(demo.getName().equals("zzz")){
        }
    }

    static class Demo{
        private String name;
        public Demo(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
