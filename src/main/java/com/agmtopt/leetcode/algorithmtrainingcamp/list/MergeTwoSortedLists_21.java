package com.agmtopt.leetcode.algorithmtrainingcamp.list;

public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ListNode tail3 = new ListNode(4, null);
        ListNode tail2 = new ListNode(2, tail3);
        ListNode tail1 = new ListNode(1, tail2);

        ListNode head3 = new ListNode(4, null);
        ListNode head2 = new ListNode(3, head3);
        ListNode head1 = new ListNode(1, head2);

        MergeTwoSortedLists_21_Solution solution = new MergeTwoSortedLists_21_Solution();
        ListNode result = solution.mergeTwoLists(tail1, head1);
        System.out.println("result : " + result);
    }

}

class MergeTwoSortedLists_21_Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(0, null);
        ListNode tail = head;

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                tail.next = list2;
                break;
            }

            if (list2 == null) {
                tail.next = list1;
                break;
            }

            if (list1.val <= list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
                continue;
            }
            tail.next = list2;
            tail = list2;
            list2 = list2.next;
        }
        return head.next;
    }
}
