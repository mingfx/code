package com.ming.code;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class N24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode before = newHead;
        while (head!=null&&head.next!=null){
            ListNode next = head.next;
            ListNode nextnext = next.next;
            before.next = next;
            next.next = head;
            head.next = nextnext;
            before = head;
            head = head.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        N24_SwapPairs swapPairs = new N24_SwapPairs();
        ListNode res = swapPairs.swapPairs(head);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
