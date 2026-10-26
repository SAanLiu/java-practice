package leetcode;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int number : count) {
            if (number != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] testCases = {
                {"anagram", "nagaram"},
                {"rat", "car"},
                {"a", "ab"},
                {"aacc", "ccac"},
                {"listen", "silent"}
        };

        for (String[] test : testCases) {
            System.out.println(
                    test[0] + " and " + test[1] + " -> "
                            + isAnagram(test[0], test[1])
            );
        }
    }
}