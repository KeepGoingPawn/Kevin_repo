package test.basic;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/17 9:22
 */
public class SwitchTest {
    public static void main(String[] args) {
        String param = null;
        switch (param){
            case "null":
                System.out.printf("null");
            default:
                System.out.println("default");
        }
    }
}
