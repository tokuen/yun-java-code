package com.yun.code.package0100.package20;

import com.yun.util.InitUtil;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 */
public class S121买卖股票的最佳时机 {
    public static void main(String[] args) {
        S121买卖股票的最佳时机 s121买卖股票的最佳时机 = new S121买卖股票的最佳时机();
        int[] ints = InitUtil.initIntArray("3,7,1,5,3,6,4");
        int i = s121买卖股票的最佳时机.maxProfit(ints);
        System.out.println(i);
    }
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0){
            return 0;
        }
        int buyValue = prices[0];
        int sellValue = 0;
        int monkey=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<buyValue){
                buyValue=prices[i];
                sellValue=0;
            }
            sellValue=Math.max(sellValue,prices[i]);
            if(sellValue-buyValue>0){
                monkey=Math.max(sellValue-buyValue,monkey);
            }
        }
        return monkey;
    }
}
