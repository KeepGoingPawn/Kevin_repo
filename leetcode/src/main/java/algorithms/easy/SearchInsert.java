package algorithms.easy;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/11 18:30
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(target <=nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] n = {1,2,3};
        int t = 4;
        int res = searchInsert(n,t);
        System.out.println(res);
    }
}
