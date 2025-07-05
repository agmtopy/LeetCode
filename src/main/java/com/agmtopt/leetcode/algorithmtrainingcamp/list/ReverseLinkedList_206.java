package com.agmtopt.leetcode.algorithmtrainingcamp.list;

import com.alibaba.fastjson2.JSON;
import lombok.ToString;

public class ReverseLinkedList_206 {

    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        ReverseLinkedList_206_Solution.ListNode node5 = new ReverseLinkedList_206_Solution.ListNode(5);
        ReverseLinkedList_206_Solution.ListNode node4 = new ReverseLinkedList_206_Solution.ListNode(4, node5);
        ReverseLinkedList_206_Solution.ListNode node3 = new ReverseLinkedList_206_Solution.ListNode(3, node4);
        ReverseLinkedList_206_Solution.ListNode node2 = new ReverseLinkedList_206_Solution.ListNode(2, node3);
        ReverseLinkedList_206_Solution.ListNode head = new ReverseLinkedList_206_Solution.ListNode(1, node2);

        System.out.println("head:" + JSON.toJSONString(head));


        ReverseLinkedList_206_Solution solution = new ReverseLinkedList_206_Solution();
        ReverseLinkedList_206_Solution.ListNode listNode = solution.reverseList(head);

        System.out.println(JSON.toJSONString(listNode));
    }

}

class ReverseLinkedList_206_Solution {
    public ListNode reverseList(ListNode head) {
        ListNode lastNode = null;
        while (head != null){
            ListNode nextNode = head.next;
            head.next = lastNode;

            lastNode = head;
            head = nextNode;
        }

        return lastNode;
    }

    @ToString
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

