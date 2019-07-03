package javase;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/24 9:15
 */
public class JavaMainMethodTest {
    public static void main(String[] args) {
        for(String str:args){
            System.out.println(str);
        }
        StringBuffer s = new StringBuffer();
        s.append("s");
    }
}
