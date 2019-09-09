package com.ming.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 * 示例 :
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *     你的算法只能使用常数的额外空间。
 *     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class N25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode before = newHead;
        ListNode start = head;
        ListNode end = head;
        int i = 1;
        while (end!=null){
            if (i == k){
                ListNode next = end.next;
                List<ListNode> listNodes = reverse(start,end);
                ListNode newSt = listNodes.get(0);
                ListNode newEd = listNodes.get(1);
                before.next = newSt;
                newEd.next = next;
                before = newEd;
                start = next;
                end = next;
                i = 1;
            }else {
                end = end.next;
                i++;
            }
        }
        return  newHead.next;
    }

    private List<ListNode> reverse(ListNode head, ListNode end){
        ListNode before = new ListNode(0);
        before.next = head;
        ListNode cur = head;
        while (before!=end){
            ListNode next = cur.next;
            cur.next = before;
            before = cur;
            cur = next;
        }
        List<ListNode> res = new ArrayList<>();
        head.next = null;
        res.add(end);
        res.add(head);
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode end = new ListNode(6);
        head.next.next.next.next.next = end;
        N25_ReverseKGroup reverseKGroup = new N25_ReverseKGroup();
        //List<ListNode> res = reverseKGroup.reverse(head,end);
        ListNode res = reverseKGroup.reverseKGroup(head,1);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
