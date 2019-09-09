package com.ming.code;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class N21_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmpNode = head;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                tmpNode.next = l1;
                l1 = l1.next;
            }else {
                tmpNode.next = l2;
                l2 = l2.next;
            }
            tmpNode = tmpNode.next;
        }
        while (l1!=null){
            tmpNode.next = l1;
            l1 = l1.next;
        }while (l2 != null){
            tmpNode.next = l2;
            l2 = l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        N21_MergeTwoLists mergeTwoLists = new N21_MergeTwoLists();
        ListNode res = mergeTwoLists.mergeTwoLists(head,head2);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
