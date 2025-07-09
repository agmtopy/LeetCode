package com.agmtopt.leetcode.algorithmtrainingcamp.list;

import com.alibaba.fastjson2.JSON;

public class ReverseNodesInKGroup_25 {

    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        System.out.println("head:" + JSON.toJSONString(head));


        ReverseNodesInKGroup_25_Solution solution = new ReverseNodesInKGroup_25_Solution();
        ListNode listNode = solution.reverseKGroup(head, 2);

        System.out.println(JSON.toJSONString(listNode));
    }

}


class ReverseNodesInKGroup_25_Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //1. 用临时节点将head节点串起来
        ListNode temp = new ListNode(0, head);
        ListNode tail = temp;

        head = tail.next;
        while (head != null) {
            //获取最后一个元素
            ListNode end = getEnd(head, k);

            if(end == null) break;
            ListNode group_head = end.next;

            //翻转元素
            this.rv(head, end);

            //设置边
            tail.next = end;
            head.next = group_head;

            //重置head
            tail = head;
            head = group_head;
        }

        return temp.next;
    }

    /**
     * 翻转元素
     */
    private void rv(ListNode head, ListNode end) {
        if (head == end) return;

        ListNode orgHead = head;

        ListNode tail = head;
        head = head.next;

        while (head != end) {
            ListNode preNode = head.next;
            head.next = tail;

            tail = head;
            head = preNode;
        }

        orgHead.next = end.next;
        end.next = tail;
    }

    private ListNode getEnd(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return head;
    }

}