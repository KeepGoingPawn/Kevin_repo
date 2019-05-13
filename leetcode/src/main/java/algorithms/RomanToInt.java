package algorithms;

import java.util.HashMap;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/13 16:48
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        int num = 0;
        int l = s.length();
        int last = 1000;
        for (int i = 0; i < l; i++){
            int v = getValue(s.charAt(i));
            if (v > last) num = num - last * 2;
            // IV = V+I - 2*I
            num = num + v;
            // num = I
            last = v;
        }
        return num;
    }
    private static int getValue(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
