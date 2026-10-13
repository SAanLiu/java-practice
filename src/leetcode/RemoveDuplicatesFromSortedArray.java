package leetcode;

import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int write = 1;

        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

        int[][] testCases = {
                {1, 1, 2},
                {0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                {1, 2, 3},
                {5, 5, 5},
                {}
        };

        for (int[] nums : testCases) {
            int[] original = nums.clone();
            int k = solution.removeDuplicates(nums);

            System.out.println(
                    Arrays.toString(original)
                            + " -> k = " + k
                            + " -> 前 k 个元素 = " + Arrays.toString(Arrays.copyOf(nums, k))
            );
        }
    }
}
