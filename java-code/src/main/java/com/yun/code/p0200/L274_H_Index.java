package com.yun.code.p0200;

import java.util.Arrays;

public class L274_H_Index {

    /**
     * Given an array of citations (each citation is a non-negative integer) of a researcher,
     * write a function to compute the researcher's h-index.
     * <p>
     * According to the definition of h-index on Wikipedia:
     * "A scientist has index h if h of his/her N papers have at least h citations each,
     * and the other N − h papers have no more than h citations each."
     * <p>
     * Example:
     * <p>
     * Input: citations = [3,0,6,1,5]
     * Output: 3
     * <p>
     * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
     * received 3, 0, 6, 1, 5 citations respectively.
     * Since the researcher has 3 papers with at least 3 citations each and the remaining
     * two with no more than 3 citations each, her h-index is 3.
     * Note: If there are several possible values for h, the maximum one is taken as the h-index.
     */

    public int hIndex2(int[] citations) {
        int[] bucket = new int[citations.length + 1];
        for (int c : citations) {
            if (c > citations.length) {
                bucket[citations.length]++;
            } else {
                bucket[c]++;
            }
        }
        int count = 0;
        for (int i = citations.length; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }
        return -1;
    }

    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }

        if (citations.length == 1) {
            if (citations[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        Arrays.sort(citations);
        int len = citations.length;

        if (citations[0] >= len) {
            return len;
        }

        for (int i = len - 1; i >= 1; i--) {

            int min = citations[i];
            int max = citations[i - 1];
            int tryValue = len - i;

            if (tryValue >= max && tryValue <= min) {
                return tryValue;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        L274_H_Index s = new L274_H_Index();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {0, 1};
        int res = s.hIndex(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}