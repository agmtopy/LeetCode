package com.agmtopt.leetcode.algorithmtrainingcamp.list;

import com.alibaba.fastjson2.JSON;

public class ReverseNodesInKGroup_25 {

    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        ListNode node5 = new ListNode(5,null);
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
        //1. 设置虚拟节点,用于排除临界条件
        ListNode protect = new ListNode(0,head);
        ListNode last = protect;

        //2. 遍历链表
        while (head != null) {
            //2.1 获取指定长度下最后一个元素
            ListNode end = this.getEndNode(head, k);

            //2.2 如果最后一个元素是null,表示已遍历到队尾
            if (end == null) break;

            //3. 暂存下一组的队首元素
            ListNode nextGroupHead = end.next;

            //4. 对[head,end]进行翻转
            this.reverseList(head, end);

            //5. end节点已经变成分组列表头节点,head节点现在是分组列表尾节点
            last.next = end;
            head.next = nextGroupHead;

            //6. 分组遍历
            last = head;
            head = nextGroupHead;
        }

        return protect.next;
    }

    /**
     * 对[headNode,endNode]中的数组进行翻转
     */
    private void reverseList(ListNode headNode, ListNode endNode) {
        //1. 两个节点相等时,直接返回
        if (headNode == endNode) {
            return;
        }

        //2. 暂存此时的队首元素
        ListNode last = headNode;
        headNode = headNode.next;
        while (headNode != endNode) {
            ListNode nextNode = headNode.next;
            headNode.next = last;

            last = headNode;
            headNode = nextNode;
        }
        endNode.next = last;
    }

    /**
     * 获取指定长度下最后一个元素
     */
    private ListNode getEndNode(ListNode head, int k) {
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