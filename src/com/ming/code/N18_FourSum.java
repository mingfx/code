package com.ming.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */
public class N18_FourSum {
    //-2 -1 0 0 1 2
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (null == nums || nums.length < 4){
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if (j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int p = j + 1;
                int q = nums.length - 1;
                while (p<q){
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum == target){
                        if (!(p>j+1&&nums[p] == nums[p-1]) && !(q<nums.length - 1&&nums[q] == nums[q+1])) {
                            lists.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        }
                        p++;
                        q--;
                    } else if (sum < target) {
                        p++;
                    } else {
                        q--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        List<List<Integer>> lists = fourSum(nums,0);
        for (List<Integer> list:
            lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
