package leetcode;

import java.util.Arrays;

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }


        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }


    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }

        return dummy.next;
    }


    private static String listToString(ListNode head) {
        StringBuilder result = new StringBuilder("[");

        while (head != null) {
            result.append(head.val);
            head = head.next;

            if (head != null) {
                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solver = new MergeTwoSortedLists();

        int[][] firstLists = {
                {1, 2, 4},
                {},
                {},
                {-3, 0, 5}
        };

        int[][] secondLists = {
                {1, 3, 4},
                {},
                {0},
                {-2, 0, 7}
        };

        for (int i = 0; i < firstLists.length; i++) {
            ListNode list1 = buildList(firstLists[i]);
            ListNode list2 = buildList(secondLists[i]);
            ListNode merged = solver.mergeTwoLists(list1, list2);

            System.out.println(
                    Arrays.toString(firstLists[i]) + " + "
                            + Arrays.toString(secondLists[i]) + " -> "
                            + listToString(merged)
            );
        }
    }
}
