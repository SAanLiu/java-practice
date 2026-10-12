package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char current = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != current) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

    public static void main(String[] args) {
        String[][] testCases = {
                {"interview", "internet", "internal"},
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"},
                {"abc", ""},
                {""},
                {"apple"},
                {}
        };

        for (String[] test : testCases) {
            String result = longestCommonPrefix(test);
            System.out.println(Arrays.toString(test) + " -> " + result);
        }
    }
}
