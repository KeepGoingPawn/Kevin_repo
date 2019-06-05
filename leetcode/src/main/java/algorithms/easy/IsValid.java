package algorithms.easy;

import java.util.Stack;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/6/5 18:29
 */
public class IsValid {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}[";
        boolean res = isValid(s);
        System.out.println(res);
    }
}
