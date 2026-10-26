package leetcode;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "A man, a plan, a canal: Panama",
                "race a car",
                " ",
                "0P",
                "No 'x' in Nixon",
                "a."
        };

        for (String test : testCases) {
            System.out.println("\"" + test + "\" -> " + isPalindrome(test));
        }
    }
}