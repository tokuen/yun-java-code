package com.yun.code.p0000;


import com.yun.code.struct.ListNode;

/**
 * Add Two Numbers
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Definition for singly-linked list.
 * public class struct.ListNode {
 * int val;
 * struct.ListNode next;
 * struct.ListNode(int x) { val = x; }
 * }
 */

public class L002_Add_Two_Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode res = new ListNode(0);
        ListNode pRes = res;

        // add
        while (p1 != null && p2 != null) {
            pRes.val = p1.val + p2.val;
            pRes.next = new ListNode(0);
            pRes = pRes.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            pRes.val = p1.val;
            pRes.next = new ListNode(0);

            pRes = pRes.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            pRes.val = p2.val;
            pRes.next = new ListNode(0);

            pRes = pRes.next;
            p2 = p2.next;
        }

        // carry
        pRes = res;
        int tempValue = 0;
        while (pRes != null) {
            pRes.val += tempValue;
            tempValue = pRes.val / 10;
            pRes.val = pRes.val % 10;
            pRes = pRes.next;
        }
        if (tempValue > 0) {
            pRes = new ListNode(0);
            pRes.val = tempValue;
        }

        // clear
        pRes = res;
        while (pRes.next.next != null) {
            pRes = pRes.next;
        }
        if (pRes.next.val == 0) {
            pRes.next = null;
        }

        return res;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode res = new ListNode(0);
        ListNode pRes = res;

        // add
        int carry = 0;
        while (p1 != null || p2 != null) {

            int val1 = (p1 != null ? p1.val : 0);
            int val2 = (p2 != null ? p2.val : 0);

            int curVal = val1 + val2 + carry;
            carry = curVal / 10;
            curVal = curVal % 10;

            pRes.next = new ListNode(curVal);
            pRes = pRes.next;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        // last step
        if (carry > 0) pRes.next = new ListNode(carry);

        return res.next;
    }

    public static void main(String[] args) {

        L002_Add_Two_Numbers s = new L002_Add_Two_Numbers();

        //        struct.ListNode l1 = new struct.ListNode(5);
        //        struct.ListNode p1 = l1;
        //        p1.next = new struct.ListNode(3);
        //        p1 = p1.next;
        //        p1.next = new struct.ListNode(6);
        //        p1 = p1.next;
        //
        //        struct.ListNode l2 = new struct.ListNode(9);
        //        l2.next = new struct.ListNode(8);


        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        ListNode p2 = l2;
        p2.next = new ListNode(6);
        p2 = p2.next;
        p2.next = new ListNode(2);

        ListNode res = s.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

