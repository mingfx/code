package com.ming.code;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 */
public class N19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode before = null;
        ListNode cur = head;
        int left = remove(before,cur,n);
        if (left==-1){
            return head.next;
        }
        return head;
    }

    private int remove(ListNode before,ListNode cur,int n){
        int left = n;
        if (cur!=null){

            left = remove(cur,cur.next,n);
            if (left>0) {
                left--;
                if (left == 0) {
                    if (before!=null) {
                        before.next = cur.next;
                    }else
                        left--;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        N19_RemoveNthFromEnd removeNthFromEnd = new N19_RemoveNthFromEnd();
        ListNode res = removeNthFromEnd.removeNthFromEnd(head,1);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}
