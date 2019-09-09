package com.ming.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class N15_ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums==null||nums.length<3){
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                break;
            }
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int p = i+1;
            int q = nums.length-1;
            while (p<q){
                int sum = nums[i]+nums[p]+nums[q];
                if (sum==0){
                    lists.add(Arrays.asList(nums[i],nums[p],nums[q]));
                    while (p<q && nums[p+1]==nums[p]) p++;
                    while (p<q && nums[q-1]==nums[q]) q--;
                    p++;
                    q--;
                }else if (sum < 0){
                    p++;
                }else{
                    q--;
                }
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list :
                lists) {
            System.out.println(list.toString());
        }
    }
}
