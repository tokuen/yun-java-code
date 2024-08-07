package com.yun.code.p0400;

import java.util.Arrays;

public class L475_Heaters {

    /**
     * Winter is coming! Your first job during the contest is
     * to design a standard heater with fixed warm radius to warm all the houses.
     * <p>
     * Now, you are given positions of houses and heaters on a
     * horizontal line, find out minimum radius of heaters
     * so that all houses could be covered by those heaters.
     * <p>
     * So, your input will be the positions of houses and heaters seperately,
     * and your expected output will be the minimum radius standard of heaters.
     * <p>
     * Note:
     * <p>
     * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
     * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
     * As long as a house is in the heaters' warm radius range, it can be warmed.
     * All the heaters follow your radius standard and the warm radius will the same.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3],[2]
     * Output: 1
     * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: [1,2,3,4],[1,4]
     * Output: 1
     * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
     */


    public int findRadius(int[] houses, int[] heaters) {

        int result = 0;
        Arrays.sort(heaters);

        for (int i = 0; i < houses.length; i++) {
            int h = houses[i];
            int index = Arrays.binarySearch(heaters, h);

            if (index < 0) {
                index = ~index;
                int dist1 = index - 1 >= 0 ? h - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - h : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(dist1, dist2));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        L475_Heaters s = new L475_Heaters();

        long sysDate1 = System.currentTimeMillis();
        int[] houses = {-1, 2, 5};
        int[] heaters = {1, 4};
        int res = s.findRadius(houses, heaters);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}