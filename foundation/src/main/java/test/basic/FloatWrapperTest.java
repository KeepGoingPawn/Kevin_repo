package test.basic;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/17 9:20
 */
public class FloatWrapperTest {
    public static void main(String[] args) {
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(0.9f - 0.8f);
        if(a.equals(b)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
