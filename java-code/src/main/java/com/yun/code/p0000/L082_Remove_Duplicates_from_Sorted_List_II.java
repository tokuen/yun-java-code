package com.yun.code.p0000;


import com.yun.code.struct.ListNode;

public class L082_Remove_Duplicates_from_Sorted_List_II {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = head;
        boolean removeHead = false;

        if (cur.next != null && cur.val == cur.next.val) {
            removeHead = true;
        }

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {

                ListNode p = cur;
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                pre.next = p.next;
            } else {
                pre = cur;
            }

            cur = pre.next;
        }

        if (removeHead) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

        L082_Remove_Duplicates_from_Sorted_List_II s = new L082_Remove_Duplicates_from_Sorted_List_II();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(1);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(4);
        f = f.next;
        f.next = new ListNode(4);
        f = f.next;
        f.next = new ListNode(5);

        ListNode res = s.deleteDuplicates(head);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}