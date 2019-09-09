package com.ming.code;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */
public class N23_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int nullCnt = 0;
        while (nullCnt!=lists.length) {
            nullCnt = 0;
            int minVal = Integer.MAX_VALUE;
            int pos = -1;
            for (int i = 0;i<lists.length;i++){
                ListNode node = lists[i];
                if (node == null) {
                    nullCnt++;
                    continue;
                }
                if (node.val<minVal){
                    minVal =  node.val;
                    pos = i;
                }
            }
            if (pos>=0) {
                cur.next = lists[pos];
                cur = cur.next;
                lists[pos] = lists[pos].next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        N23_MergeKLists mergeKLists = new N23_MergeKLists();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        //node3.next.next = new ListNode(5);
        ListNode[] listNodes = {node1,node2,node3};
        ListNode res = mergeKLists.mergeKLists(listNodes);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
