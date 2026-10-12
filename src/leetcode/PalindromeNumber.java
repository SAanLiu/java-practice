package leetcode;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String original = String.valueOf(x);
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }
    public static void main(String[] args) {
        int x = 8989898;
        System.out.println(isPalindrome(x));
    }
}
