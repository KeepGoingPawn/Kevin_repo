package search;

/**
 * @Author:Kevin
 * @Description:binary search
 * @Date: 2019/5/5 16:33
 */
public class BinarySearch {

    public static int recursion(int[] array, int start, int end, int target) {
        int low = start;
        int high = end;
        int mid = (low + high) >>> 1;
        int midVal = array[mid];
        if (target < array[low] || target > array[high]) {
            return -1;
        }
        if (midVal > target) {
            return recursion(array, low, mid - 1, target);
        } else if (midVal < target) {
            return recursion(array, mid + 1, high, target);
        } else if (midVal == target) {
            return mid;
        }
        return -1;
    }

    public static int circle(int[] array, int start, int end, int target) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = array[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

