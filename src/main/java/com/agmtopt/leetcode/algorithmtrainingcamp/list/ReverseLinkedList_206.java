package com.agmtopt.leetcode.algorithmtrainingcamp.list;

import com.alibaba.fastjson2.JSON;
import lombok.ToString;

public class ReverseLinkedList_206 {

    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        System.out.println("head:" + JSON.toJSONString(head));


        ReverseLinkedList_206_Solution solution = new ReverseLinkedList_206_Solution();
        ListNode listNode = solution.reverseList(head);

        System.out.println(JSON.toJSONString(listNode));
    }

}

class ReverseLinkedList_206_Solution {

    /**
     * 遍历节点处理
     */
    public ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        ListNode nextNode = null;
        while (curNode != null) {
            ListNode preNode = curNode.next;
            curNode.next = nextNode;

            nextNode = curNode;
            curNode = preNode;
        }

        return curNode;
    }


    /**
     * 递归处理
     */
    public ListNode reverseList1(ListNode head) {
        return this.recursion(head, null);
    }

    private ListNode recursion(ListNode curNode, ListNode preNode) {
        if (curNode == null) {
            return preNode;
        }

        ListNode resNode = this.recursion(curNode.next, curNode);
        curNode.next = preNode;
        return resNode;
    }
}

