package com.yun.code.p0000;

public class L027_Remove_Element {


    public int removeElement(int[] nums, int val) {
        int res = 0;

        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
            } else {
                if (i != j) {
                    nums[i] = nums[j];
                }
                i++;
                j++;
            }
        }

        return i;
    }

    public static void main(String[] args) {

        L027_Remove_Element s = new L027_Remove_Element();

        int nums[] = {1, 1};
        int val = 1;

        long sysDate1 = System.currentTimeMillis();

        int res = s.removeElement(nums, val);
        System.out.print("res:");
        System.out.println(res);

        System.out.println("nums:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}