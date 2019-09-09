package com.ming.code;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNum {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }

        ListNode head;
        ListNode res = new ListNode(0);
        head = res;
        int last = 0;
        while(last!=0||l1!=null||l2!=null){

            int amount = l1.val + l2.val + last;
            if(amount > 9){
                last = amount/10;
                amount = amount%10;
            }else{
                last = 0;
            }
            ListNode tmp = new ListNode(amount);
            res.next = tmp;
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
//        while(l1!=null){
//            res.next = l1;
//            l1 = l1.next;
//        }
//        while(l2!=null){
//            res.next = l2;
//            l2 = l2.next;
//        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2  = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(node1,node2);
        while (res!=null){
            System.out.println(res.val+"->");
            res = res.next;
        }
        ListNode node3 = new ListNode(9);
        node3.next = new ListNode(1);
        node3.next.next = new ListNode(6);
        ListNode node4  = new ListNode(0);
        ListNode res2 = addTwoNumbers(node3,node4);
        while (res2!=null){
            System.out.println(res.val+"->");
            res2 = res2.next;
        }
    }
}

