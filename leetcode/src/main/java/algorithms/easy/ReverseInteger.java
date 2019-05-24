package algorithms.easy;

import static java.lang.Math.abs;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/7 9:08
 */
public class ReverseInteger {
    /**
      * @Description:use long variable
      * @Date: 2019/5/7 9:55
      */
    public static int reverse(int x) {
        long res = 0;
        while(x!=0){
            res = x%10 + res*10;
            x /= 10;
        }
        return (res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)? 0 : (int)res;
    }

    /**
      * @Description: not use long variable
      * @Date: 2019/5/7 9:56
      * @Param:
      * @Return:
      */
    public static int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            if (abs(res) > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = reverse1(2147483645);
        System.out.println(res);
    }
}
