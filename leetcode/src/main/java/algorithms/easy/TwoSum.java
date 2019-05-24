package algorithms.easy;

import java.util.Arrays;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/6 14:49
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length< 2){
            return null;
        }
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++ ){
            for(int j=0;j<i;j++){
                if(nums[i]+ nums[j]==target){
                    result[0] = j;
                    result[1] = i;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int resule[] = twoSum(nums,3);
        System.out.println(Arrays.toString(resule));
    }
}
