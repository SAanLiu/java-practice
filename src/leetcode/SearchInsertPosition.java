package leetcode;

import java.util.Arrays;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 没找到时，left 就是应该插入的位置
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int[] targets = {5, 2, 7, 0, 6};

        for (int target : targets) {
            System.out.println(
                    "数组：" + Arrays.toString(nums)
                            + "，目标：" + target
                            + "，结果：" + searchInsert(nums, target)
            );
        }

        // 只有一个元素的数组
        int[] single = {4};
        System.out.println("数组：[4]，目标：4，结果：" + searchInsert(single, 4));
        System.out.println("数组：[4]，目标：2，结果：" + searchInsert(single, 2));
        System.out.println("数组：[4]，目标：8，结果：" + searchInsert(single, 8));
    }
}