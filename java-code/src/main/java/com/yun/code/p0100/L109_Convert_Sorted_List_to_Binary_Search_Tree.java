package com.yun.code.p0100;


import com.yun.code.struct.TreeNode;
import com.yun.code.struct.ListNode;

public class L109_Convert_Sorted_List_to_Binary_Search_Tree {


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        TreeNode treeHead = new TreeNode(slow.val);
        if (head == slow) {
            return treeHead;
        } else {
            treeHead.left = sortedListToBST(head);
            treeHead.right = sortedListToBST(slow.next);
        }

        return treeHead;
    }

    public static void main(String[] args) {

        L109_Convert_Sorted_List_to_Binary_Search_Tree s = new L109_Convert_Sorted_List_to_Binary_Search_Tree();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(4);
        f = f.next;
        f.next = new ListNode(5);
        f = f.next;
        f.next = new ListNode(6);

        TreeNode res = s.sortedListToBST(head);

        System.out.println(res.val);
        System.out.println(res.left.val);
        System.out.println(res.right.val);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}