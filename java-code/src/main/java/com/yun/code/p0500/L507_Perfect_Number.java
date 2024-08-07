package com.yun.code.p0500;

public class L507_Perfect_Number {

    /*
     * Euclid proved that
     * 2^{p−1}(2^p − 1) is an even perfect number whenever 2^p − 1 is prime, where p is prime.
     * For example, the first four perfect numbers are generated by the formula
     *  2^{p−1}(2^p − 1), with p a prime number, as follows:
     * for p = 2:   21(22 − 1) = 6
     * for p = 3:   22(23 − 1) = 28
     * for p = 5:   24(25 − 1) = 496
     * for p = 7:   26(27 − 1) = 8128.
     * Prime numbers of the form 2^p − 1 are known as Mersenne primes. For 2^p − 1 to be prime,
     * it is necessary that pp itself be prime.
     * However, not all numbers of the form 2^p − 1 with a prime pp are prime; for example,
     *  2^{11} − 1 = 2047 = 23 × 89 is not a prime number.
     * You can see that for small value of p,
     * its related perfect number goes very high. So, we need to evaluate perfect numbers for some primes
     *  (2, 3, 5, 7, 13, 17, 19, 31) only,
     * as for bigger prime its perfect number will not fit in 64 bits.
     *
     */

    public boolean checkPerfectNumber(int num) {

        if (num == 1) {
            return false;
        }

        int sum = 0;
        sum += 1;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i != i) {
                    sum += num / i;
                    sum += i;
                } else {
                    sum += i;
                }
            }

            if (sum > num) {
                return false;
            }
        }

        if (sum == num) {
            return true;
        }

        return false;
    }

    public boolean checkPerfectNumber2(int num) {
        int[] primes = new int[]{2, 3, 5, 7, 13, 17, 19, 31};

        for (int prime : primes) {
            if (pn(prime) == num) {
                return true;
            }
        }
        return false;
    }

    private int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }

    public static void main(String[] args) {

        L507_Perfect_Number s = new L507_Perfect_Number();
        long sysDate1 = System.currentTimeMillis();
        int score = 25;
        boolean res = s.checkPerfectNumber(score);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}