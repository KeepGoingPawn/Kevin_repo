package test.basic;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/17 9:19
 */
public class FloatBasicTest {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        if(a == b){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}