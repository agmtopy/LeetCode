package com.agmtopt.leetcode.algorithmtrainingcamp.list;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleIi_142 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ListNode node4 = new ListNode(-4, null);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(3, node2);

        LinkedListCycleIi_142_Solution solution = new LinkedListCycleIi_142_Solution();
        ListNode result = solution.hasCycle(head);
        System.out.println("result : " + result);
    }

}


class LinkedListCycleIi_142_Solution {

    public ListNode hasCycle(ListNode head) {
        if (head == null) return null;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
}