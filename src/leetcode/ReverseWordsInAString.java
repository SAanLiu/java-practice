package leetcode;

public class ReverseWordsInAString {
    public static String reverseWords(String text) {
        String trimmed = text.trim();

        if (trimmed.isEmpty()) {
            return "";
        }

        String[] words = trimmed.split("\\s+");

        int left = 0;
        int right = words.length - 1;

        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String[] testCases = {
                "the sky is blue",
                "  hello world  ",
                "a good   example",
                "one",
                "  Bob    Loves  Alice   "
        };

        for (String test : testCases) {
            System.out.println(test + " -> " + reverseWords(test));
        }
    }
}