package javase;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/14 10:23
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "string";
        String s2 = "string";
        String s3 = new String("string");
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        String s4 = s3.intern();
        System.out.println(s1 ==s4);
    }
}
