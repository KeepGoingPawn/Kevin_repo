package algorithms.easy;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/3 16:19
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int cursor = 0;
        for(int i = 0; i < nums.length; i++ ){
            if(nums[i]!=val){
                nums[cursor] = nums[i];
                cursor++;
            }
        }
        return cursor;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4};
        int res = removeElement(nums,3);
        System.out.println(res);
    }
}
