package com.yun.code.p0000;

public class L006_ZigZag_Conversion {


    // 写sample，找规律
    public String convert(String s, int numRows) {

        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        int interval = (numRows - 1) * 2;

        StringBuilder res = new StringBuilder();
        int span1 = interval;
        int span2 = 0;

        for (int i = 0; i < numRows; i++) {

            StringBuilder tempSB = new StringBuilder();

            for (int j = i; j < s.length(); ) {

                if (span1 > 0) {
                    tempSB.append(s.charAt(j));
                    j = j + span1;
                }

                if (j >= s.length()) {
                    break;
                }

                if (span2 != span1 && span2 > 0) {
                    tempSB.append(s.charAt(j));
                    j = j + span2;
                }
            }

            res.append(tempSB);

            span1 -= 2;
            span2 += 2;
        }
        return res.toString();
    }

    public static void main(String[] args) {

        L006_ZigZag_Conversion s = new L006_ZigZag_Conversion();

        long sysDate1 = System.currentTimeMillis();

        String input = "AB";

        String res = s.convert(input, 1);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}