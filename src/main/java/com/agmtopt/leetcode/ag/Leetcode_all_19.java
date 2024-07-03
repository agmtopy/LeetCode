package com.agmtopt.leetcode.ag;

import com.agmtopt.leetcode.ag.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_all_19 {

    public static void main(String[] args) {
        ListNode head = constructListNode1();

        Solution solution = new Solution();
        solution.removeNthFromEnd(head,2);

        System.out.println(head);
     }

    private static ListNode constructListNode1() {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        return node1;
    }

    /**
     * 删除链表中的指定的后第N个元素
     */
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            List<ListNode> ls = new ArrayList<>();

            ListNode tempNode = head;
            while (null != tempNode){
                ls.add(tempNode);
                tempNode = tempNode.next;
            }

            ls.get(ls.size() - n - 1).next = ls.get(ls.size() - n).next;
            ls.get(ls.size() - n).next = null;

            return head;
        }
    }
}