package com.yun.code.package0000.package10;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class S11盛最多水的容器 {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxarea;
    }
    public int maxArea2(int[] height) {
        int left=0,right=height.length-1;
        int maxArea=0;
        while (left<right){
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea=Math.max(maxArea,area);
            if(height[left+1] > height[right-1]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}