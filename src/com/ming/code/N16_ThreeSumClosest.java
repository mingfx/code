package com.ming.code;


import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class N16_ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (null == nums || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int p = i+1;
            int q = nums.length - 1;
            int last = Integer.MAX_VALUE;
            while (p < q){
                int tmp = nums[i] + nums[p] + nums[q];
                min = Math.abs(tmp - target) < Math.abs(min - target) ? tmp : min;
//                if (last < Math.abs(tmp-target)){
//                    break;
//                }
                if (tmp < target){
                    p++;
                }else if (tmp > target){
                    q--;
                }else {
                    return target;
                }
                last = Math.abs(tmp - target);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
        System.out.println(threeSumClosest(arr,0));
    }
}
