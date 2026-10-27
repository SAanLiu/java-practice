package leetcode;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            count[index]--;

            if (count[index] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] testCases = {
                {"a", "b"},
                {"aa", "ab"},
                {"aa", "aab"},
                {"abc", "cba"},
                {"aba", "baa"},
                {"aaa", "aab"}
        };

        for (String[] test : testCases) {
            System.out.println(
                    "ransomNote = \"" + test[0]
                            + "\", magazine = \"" + test[1]
                            + "\" -> " + canConstruct(test[0], test[1])
            );
        }
    }
}