package algorithms;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/15 19:13
 */
public class LongestCommonPrifix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {
        String[] strs = {"s7as","saa1s","saa11"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
