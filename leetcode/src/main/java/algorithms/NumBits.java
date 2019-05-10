package algorithms;

import static java.lang.Math.abs;

/**
 * @Author:Kevin
 * @Description:obtain a num's bit
 * @Date: 2019/5/10 8:56
 */
public class NumBits {
    public static int getNumBit(int x){
        int count = 1;
        while(abs(x)>9){
            x/=10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getNumBit(0));
    }
}
