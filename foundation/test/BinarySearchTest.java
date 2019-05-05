import org.junit.Test;
import search.BinarySearch;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/5 16:50
 */
public class BinarySearchTest {
    @Test
    public void test(){
        int[] arr = {1,5,6,7,8,12,14};
        int res = BinarySearch.recursion(arr,0,arr.length-1,5);
        System.out.println(res);
    }
}
