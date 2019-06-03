package algorithms.easy;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/3 16:59
 */
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int j=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4,4};
        int n = removeDuplicates(nums);
        System.out.println(n);
    }
}
