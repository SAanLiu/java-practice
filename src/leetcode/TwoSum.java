package leetcode;

import java.util.*;

public class TwoSum {
    //way1
    public static int[] twoSumForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    //way2
    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (seen.containsKey(need)) {
                return new int[] {seen.get(need), i};
            }

            seen.put(nums[i], i);
        }
        return new int[] {};
    }

    //test
    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        System.out.println("第一组，两层循环：" + Arrays.toString(twoSumForce(nums1, target1)));
        System.out.println("第一组，HashMap：" + Arrays.toString(twoSumHashMap(nums1, target1)));

        int[] nums2 = {3, 3};
        int target2 = 6;

        System.out.println("第二组，两层循环：" + Arrays.toString(twoSumForce(nums2, target2)));
        System.out.println("第二组，HashMap：" + Arrays.toString(twoSumHashMap(nums2, target2)));
    }
}
