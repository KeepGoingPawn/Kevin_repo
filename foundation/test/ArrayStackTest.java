import datastructure.impl.ArrayStack;
import org.junit.Test;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/5 16:12
 */
public class ArrayStackTest {
    @Test
    public void test() {
        ArrayStack as = new ArrayStack(4);
        int[] src = {5,8,9,7};
        for(int i = 0; i< src.length; i++){
            as.push(src[i]);
        }
        for(int i = 0; i<src.length;i++){
            System.out.print(as.pop());
        }
    }
}
