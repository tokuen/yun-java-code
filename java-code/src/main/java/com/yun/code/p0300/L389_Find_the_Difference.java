package com.yun.code.p0300;

public class L389_Find_the_Difference {

    /*

    0 <= s.length <= 1000
    t.length == s.length + 1
    s and t consist of lowercase English letters.

    String t is generated by random shuffling string s
        and then add one more letter
            at a random position.

     */

    public char findTheDifference(String s, String t) {

        int[] count = new int[26];
        for (Character c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (Character c : t.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return (char) (i + 'a');
            }
        }

        return 'a';
    }

    /*
    利用char sum去看差值
     */
    public char findTheDifference2(String s, String t) {

        char s1[] = s.toCharArray();
        char t1[] = t.toCharArray();
        int ans = 0;

        for (int i = 0; i < s1.length; i++) {
            ans = ans + t1[i] - s1[i];
        }
        ans = ans + t1[t1.length - 1];

        return (char) ans;
    }

    public static void main(String[] args) {

        L389_Find_the_Difference s = new L389_Find_the_Difference();
        long sysDate1 = System.currentTimeMillis();

        String ss = "abcd";
        String tt = "aedbc";
        char res = s.findTheDifference2(ss, tt);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}