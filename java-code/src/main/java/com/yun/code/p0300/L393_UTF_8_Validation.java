package com.yun.code.p0300;

public class L393_UTF_8_Validation {

    public boolean validUtf8(int[] data) {

        // Number of bytes in the current UTF-8 character
        int numberOfBytesToProcess = 0;

        // For each integer in the data array.
        for (int i = 0; i < data.length; i++) {

            // Get the binary representation. We only need the least significant 8 bits
            // for any given number.
            String binRep = Integer.toBinaryString(data[i]);
            binRep =
                    binRep.length() >= 8
                            ? binRep.substring(binRep.length() - 8)
                            : "00000000".substring(binRep.length() % 8) + binRep;

            // If this is the case then we are to start processing a new UTF-8 character.
            if (numberOfBytesToProcess == 0) {

                // Get the number of 1s in the beginning of the string.
                for (int j = 0; j < binRep.length(); j++) {
                    if (binRep.charAt(j) == '0') {
                        break;
                    }

                    numberOfBytesToProcess += 1;
                }

                // 1 byte characters
                if (numberOfBytesToProcess == 0) {
                    continue;
                }

                // Invalid scenarios according to the rules of the problem.
                if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
                    return false;
                }

            } else {

                // Else, we are processing integers which represent bytes which are a part of
                // a UTF-8 character. So, they must adhere to the pattern `10xxxxxx`.
                if (!(binRep.charAt(0) == '1' && binRep.charAt(1) == '0')) {
                    return false;
                }
            }

            // We reduce the number of bytes to process by 1 after each integer.
            numberOfBytesToProcess -= 1;
        }

        // This is for the case where we might not have the complete data for
        // a particular UTF-8 character.
        return numberOfBytesToProcess == 0;
    }


    public static void main(String[] args) {

        L393_UTF_8_Validation s = new L393_UTF_8_Validation();
        long sysDate1 = System.currentTimeMillis();

        // int[] data = {255}; // false
        // int[] data = {197,130,1}; // true
        // int[] data = {197,130,1}; // true
        // int[] data = {235,140,4}; // false
        // int[] data = {240,162,138,147,145}; // false
        // int[] data = {230,136,145}; // true
        int[] data = {250, 145, 145, 145, 145}; // false
        // int [] data = {240,162,138,147,17}; // true

        boolean res = s.validUtf8(data);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}