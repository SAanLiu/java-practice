package leetcode;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String original = String.valueOf(x);
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }

    public static boolean isPalindromeByDigits(int x) {
        if (x < 0) {
            return false;
        }

        int original = x;
        long reversed = 0;

        while (x > 0) {
            int digit = x % 10;              // 取出最后一位
            reversed = reversed * 10 + digit; // 拼到反转结果后面
            x = x / 10;                      // 去掉最后一位
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        int[] testNumbers = {
                0,
                7,
                -1,
                -121,
                10,
                120,
                121,
                1001,
                123,
                8989898
        };

        for (int x : testNumbers) {
            System.out.println(x + " -> 字符串解法：" + isPalindrome(x) + "，逐位取数解法：" + isPalindromeByDigits(x)
            );
        }
    }
}
