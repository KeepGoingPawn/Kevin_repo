package algorithms;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/8 9:10
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if(n < 0){
            return false;
        }
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1){
                count++;
            }
            if(count >1){
                return false;
            }
            n = n>>>1;
        }
        if(count ==1) {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isPowerOfTwo2(int n) {
        //网上高票回答
        return n>0 && Integer.bitCount(n) == 1;
    }

    public static boolean isPowerOfTwo3(int n) {
        //I like this answer.
        return n > 0 && ((n & (n-1)) == 0);
    }

    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    public static void main(String[] args) {
        boolean res = isPowerOfTwo(3);
        System.out.println(res);
    }
}
