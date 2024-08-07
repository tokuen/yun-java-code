package com.yun.code.p0100;

import java.util.ArrayList;
import java.util.List;

public class L139_Word_Break {

    /*
     *
     * DP 做法
     * dp[i] = true 表示 s 到第i位，是可以有字典组成的
     * = false，表示不可以组成。
     *
     * dp [i] = true
     *      存在一个j使得：dp[j] == true && s[j,i] 在字典库中
     *
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /*
     *  回溯搜索算法
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0, new boolean[s.length()]);
    }

    private static boolean wordBreak(String s, List<String> wordDict, int startIndex, boolean[] visited) {

        // 结束条件
        if (s.length() == startIndex) {
            return true;
        }

        if (visited[startIndex]) {
            return false;
        }

        visited[startIndex] = true;

        // 遍历每个单词，递归
        for (String word : wordDict) {
            if (s.startsWith(word, startIndex)
                    && wordBreak(s, wordDict, startIndex + word.length(), visited)) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        L139_Word_Break s = new L139_Word_Break();

        long sysDate1 = System.currentTimeMillis();

        String ss = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        boolean res = s.wordBreak(ss, wordDict);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}