package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> common = new HashSet<>();

        for (int number : nums1) {
            first.add(number);
        }

        for (int number : nums2) {
            if (first.contains(number)) {
                common.add(number);
            }
        }

        int[] result = new int[common.size()];
        int i = 0;

        for (int number : common) {
            result[i] = number;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] firstTests = {
                {1, 2, 2, 1},
                {4, 9, 5},
                {1, 2, 3},
                {5, 5, 5}
        };

        int[][] secondTests = {
                {2, 2},
                {9, 4, 9, 8, 4},
                {4, 5, 6},
                {5}
        };

        for (int i = 0; i < firstTests.length; i++) {
            int[] result = intersection(firstTests[i], secondTests[i]);
            Arrays.sort(result);

            System.out.println(
                    Arrays.toString(firstTests[i]) + " ∩ "
                            + Arrays.toString(secondTests[i]) + " -> "
                            + Arrays.toString(result)
            );
        }
    }
}