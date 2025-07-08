package com.agmtopt.leetcode.algorithmtrainingcamp.list;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle_141 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ListNode node4 = new ListNode(-4, null);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(3, node2);


        LinkedListCycle_141_Solution solution = new LinkedListCycle_141_Solution();
        boolean result = solution.hasCycle1(head);

        System.out.println("result : " + result);
    }
}

class LinkedListCycle_141_Solution {

    public boolean hasCycle1(ListNode head) {

        if(head == null) return false;


        int sideNum = 0;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (sideNum >  1000) {
                return true;
            }
            nextNode = nextNode.next;
            sideNum++;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        List<ListNode> temps = new ArrayList<>();
        temps.add(head);
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (temps.contains(nextNode)) {
                return true;
            }
            temps.add(nextNode);
            nextNode = nextNode.next;
        }
        return false;
    }
}