package com.yun.code.p0100;

import com.yun.code.struct.ListNode;

public class L141_Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode p1, p2;
        p1 = head;
        p2 = head.next;

        while (p1 != p2) {
            if (p1 == null || p2 == null) return false;

            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) p2 = p2.next;
            else return false;

        }
        return true;
    }

    public static void main(String[] args) {

        L141_Linked_List_Cycle s = new L141_Linked_List_Cycle();

        long sysDate1 = System.currentTimeMillis();

        ListNode l = new ListNode(1);

        boolean res = s.hasCycle(l);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}