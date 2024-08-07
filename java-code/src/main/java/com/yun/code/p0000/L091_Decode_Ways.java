package com.yun.code.p0000;

public class L091_Decode_Ways {

    /**
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * <p>
     * 解法
     * count[i] 表示s中前i个字符组成的子串的解码方法的个数，
     * <p>
     * 初始化：
     * 长度比输入数组长多多1，并将 count[0] 初始化为1
     * <p>
     * 递归方程：
     * 前一位 为'0'， count[i] = 0
     * 前一位 不为'0'，count[i] = count[i-1]
     * 前两位 在[10,26]之间，count[i] += count[i-2]
     * <p>
     * 1234
     */

    public int numDecodings(String s) {

        int[] count = new int[s.length() + 1];

        count[0] = 1;
        for (int i = 1; i <= s.length(); i++) {

            if (s.charAt(i - 1) == '0') {
                count[i] = 0;
            } else {
                count[i] = count[i - 1];
            }

            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                count[i] += count[i - 2];
            }
        }

        return count[s.length()];
    }

    public static void main(String[] args) {

        L091_Decode_Ways s = new L091_Decode_Ways();

        long sysDate1 = System.currentTimeMillis();

        int res = s.numDecodings("0");
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}