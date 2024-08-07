package com.yun.code.p0300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L392_Is_Subsequence {

    /**
     * Given a string s and a string t, check if s is subsequence of t.
     * <p>
     * You may assume that there is only lower case English
     * letters in both s and t. t is potentially a very
     * long (length ~= 500,000) string, and s is a short string (<=100).
     * <p>
     * A subsequence of a string is a new string
     * which is formed from the original string
     * by deleting some (can be none) of the
     * characters without disturbing the relative
     * positions of the remaining characters.
     * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
     * <p>
     * Example 1:
     * s = "abc", t = "ahbgdc"
     * <p>
     * Return true.
     * <p>
     * Example 2:
     * s = "axc", t = "ahbgdc"
     * <p>
     * Return false.
     * <p>
     * Follow up:
     * If there are lots of incoming S, say S1, S2, ... ,
     * Sk where k >= 1B, and you want to check one by
     * one to see if T has its subsequence. In this scenario,
     * how would you change your code?
     */

    public boolean isSubsequence(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == len1) {
            return true;
        }
        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        char[] ss = s.toCharArray();
        int j = 0;
        for (int i = 0; i < ss.length; i++) {
            j = t.indexOf(ss[i], j);
            if (j == -1)
                return false;
            j++;
        }
        return true;
    }

    /*
    Our current solution is O(n), where n is the length of t.
    If there are lots of incoming s,
    out solution won't be satisfactory because n is very large.
Binary search. For each character from a - z,
create a list of indices where the character occurs in t.
Iterate through s. For each character in s,
go to its corresponding list, and binary search 
for the earliest index where the character occurs in t.
Use a variable "previous" to keep track of that index.
If in any iteration, binary search returns an index
that's out of range of the list, return false,
because that means a character that appears later in s has no match in t.
     */
    public boolean isSubsequence3(String s, String t) {
        List<Integer>[] positions = new List[26];

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = c - 'a';
            if (positions[index] == null) {
                positions[index] = new ArrayList<>();
            }
            positions[index].add(i);
        }

        int last = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (positions[index] == null) {
                return false;
            }
            int insertion = Collections.binarySearch(positions[index], last);
            if (insertion < 0) {
                insertion = -(insertion + 1);
            }
            if (insertion == positions[index].size()) {
                return false;
            }
            last = positions[index].get(insertion) + 1;
        }

        return true;
    }

    public static void main(String[] args) {

        L392_Is_Subsequence s = new L392_Is_Subsequence();
        long sysDate1 = System.currentTimeMillis();

        String a = "ab";
        String b = "cad";
        boolean res = s.isSubsequence(a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}