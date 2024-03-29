package com.yun.code.package0000.package00;

class S02两数相加 {
    /*
        给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
        你可以假设除了数字 0 之外，这两个数字都不会以零开头。
        示例：
        输入：(2 -> 4 -> 3) +
             (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode value = new ListNode(0);
        while (l1 != null || l2 != null) {
            int x = 0, y = 0;
            if (l1 == null) {
                x = 0;
                y = l2.val;
            }
            if (l2 == null) {
                x = l1.val;
                y = 0;
            }
            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            value.next = new ListNode(sum);
        }
        if (carry > 0) {
            value.next = new ListNode(carry);
        }
        return value.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}