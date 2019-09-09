package com.ming.code;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class N11_MaxArea {
    //暴力法 n2  过不了
    public static int maxArea(int[] height) {
        int len = height.length;
        int[][] arr = new int[len][len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int dim = j - i;
                max = Math.max(max, dim * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    /**
     * 双指针法，从两头开始，每次值较小的指针向里走一步，看里面是不是有比当前max值大的
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int dim = j - i;
            max = Math.max(max, dim * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else
                j--;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }
}