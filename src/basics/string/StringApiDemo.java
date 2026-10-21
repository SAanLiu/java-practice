package basics.string;

public class StringApiDemo {
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
        System.out.println(reverseWords(" the sky is blue "));
        System.out.println(reverseWords("  the   sky  is   blue  "));
        System.out.println(reverseWords("hello"));
        System.out.println("Empty result: [" + reverseWords("   ") + "]");
    }
}