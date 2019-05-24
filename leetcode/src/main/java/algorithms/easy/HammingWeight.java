package algorithms.easy;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/8 8:40
 */
public class HammingWeight {
    public static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1){
                count++;
            }
            n = n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "1111111111111111111111111111111";
        int n = Integer.parseInt(str,2);
        System.out.println(n);
        System.out.println(Integer.MAX_VALUE);
        int count = hammingWeight(n);
        System.out.println(count);

    }
}
