package com.yun.code.p0000;


import com.yun.code.struct.ListNode;

public class L019_Remove_Nth_Node_From_End_of_List {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1;
        ListNode p = head;
        while (i < n) {
            p = p.next;
            i++;
        }

        ListNode q = head;

        if (p.next == null) {
            head = head.next;
            return head;
        }

        p = p.next;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return head;
    }

    public static void main(String[] args) {

        L019_Remove_Nth_Node_From_End_of_List s = new L019_Remove_Nth_Node_From_End_of_List();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(4);

        ListNode res = s.removeNthFromEnd(head, 4);
        while (res != null) {
            System.out.println("->" + res.val);
            res = res.next;
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}