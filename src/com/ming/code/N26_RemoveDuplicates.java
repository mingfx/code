package com.ming.code;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class N26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length<2) {
            return nums.length;
        }
        int i = 0;
        int j = 1;
        while (j<nums.length){
            if (nums[j]==nums[i]){
                j++;
            }else {
                if (j>i+1){
                    swap(nums,i+1,j);
                }
                i++;
                j++;
            }
        }
        return i+1;
    }

    private void swap(int[] arr,int i,int j){
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int[] arr1 = {0};
        int[] arr2 = {};
        int[] arr3 = {0,1};
        N26_RemoveDuplicates removeDuplicates = new N26_RemoveDuplicates();
        int t = removeDuplicates.removeDuplicates(arr3);
        for (int i = 0; i < t; i++) {
            System.out.println(arr3[i]);
        }
    }
}
