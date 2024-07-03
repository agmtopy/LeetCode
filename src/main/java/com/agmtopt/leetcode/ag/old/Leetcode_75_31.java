package com.agmtopt.leetcode.ag.old;

import com.agmtopt.leetcode.ag.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_75_31 {

    public static void main(String[] args) {
        ListNode lista5 = new ListNode(10, null);
        ListNode lista4 = new ListNode(8, lista5);
        ListNode lista3 = new ListNode(6, lista4);
        ListNode lista2 = new ListNode(4, lista3);
        ListNode lista1 = new ListNode(2, lista2);
        ListNode lista0 = new ListNode(0, lista1);

        lista5.setNext(lista2);

        ListNode listb5 = new ListNode(9, null);
        ListNode listb4 = new ListNode(7, listb5);
        ListNode listb3 = new ListNode(5, listb4);
        ListNode listb2 = new ListNode(3, listb3);
        ListNode listb1 = new ListNode(1, listb2);

        ListNode listNode = new Leetcode_75_42_do().detectCycle(lista0);
        System.out.println(listNode);
    }
}

class Leetcode_75_42_do {
    //查找循环第一个节点
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<ListNode>();
        ListNode curr = head;
        while (curr != null) {
            if(list.contains(curr)){
                return curr;
            }

            list.add(curr);
            curr = curr.next;
        }
        return null;
    }
}

class Leetcode_75_31_do {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}

class Leetcode_75_41_do {
    //查找中位数
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int total = 0;
        ListNode curr = head;
        ListNode middleNode = head;

        while (curr != null) {
            total = total + 1;
            if (total % 2 == 0) {
                middleNode = middleNode.next;
            }
            curr = curr.next;
        }
        return middleNode;
    }
}