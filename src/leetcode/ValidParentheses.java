package leetcode;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char left = stack.pop();

                if ((current == ')' && left != '(') ||
                        (current == ']' && left != '[') ||
                        (current == '}' && left != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        String[] testCases = {
                "()",
                "()[]{}",
                "{[]}",
                "(]",
                "([)]",
                "(",
                "]",
                ""
        };

        for (String test : testCases) {
            System.out.println(test + " -> " + solution.isValid(test));
        }
    }
}
