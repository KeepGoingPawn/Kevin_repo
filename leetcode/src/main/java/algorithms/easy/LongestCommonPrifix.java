package algorithms.easy;

import java.util.Arrays;

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
        String[] strs = {"saas","sbas1","sab"};
        Arrays.sort(strs);
        String s = longestCommonPrefix(strs);
        String sa= "sad";
        //验证String.indexOf("a")==0
        System.out.println(sa.indexOf("sa")==0);
    }
}
