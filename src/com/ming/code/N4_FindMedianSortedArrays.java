package com.ming.code;

/**
 * 寻找两个有序数组的中位数
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class N4_FindMedianSortedArrays {
    //    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int amount = nums1.length+nums2.length;
//        int l = (int) Math.ceil(amount/2.0);
//        int r = (int) Math.floor(amount/2.0);
//        int t1 = 0;
//        int t2 = 0;
//        double lV = nums1[0];
//        double rV = nums2[0];
//        while (t1+t2 <= r){
//            if (t1<nums1.length && nums1[t1]<nums2[t2]){
//                if (t1+t2 == l){
//                    lV = nums1[l-1];
//                }
//                t1++;
//            }else {
//                if (t1+t2 == l){
//                    rV = nums2[r-1];
//                }
//                t2++;
//            }
//        }
//        return (lV+rV)/2.0;
//    }
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        //also could sort first
//
//        //[1] [1]
//        int amount = nums1.length + nums2.length;
//
//        if (amount % 2 == 0) {
//
//            int l = amount / 2 - 1;
//            int r = amount / 2;
//            if (nums2.length==0){
//                return (nums1[l]+nums1[r])/2;
//            }
//            int t1 = 0;
//            int t2 = 0;
//            double lV = 0;
//            double rV = 0;
//            while (t1 + t2 <= r) {
//                if (t1 < nums1.length && nums1[t1] < nums2[t2]) {
//                    if (t1 + t2 == l) {
//                        lV = nums1[t1];
//                    } else if (t1 + t2 == r) {
//                        rV = nums1[t1];
//                    }
//                    t1++;
//                } else if (t2 < nums2.length){
//                    if (t1 + t2 == l) {
//                        lV = nums2[t2];
//                    } else if (t1 + t2 == r) {
//                        rV = nums2[t2];
//                    }
//                    t2++;
//                } else {
//                    if (t1 + t2 == l) {
//                        lV = nums1[t1];
//                    } else if (t1 + t2 == r) {
//                        rV = nums1[t1];
//                    }
//                    t1++;
//                }
//            }
//            return (lV + rV) / 2.0;
//        } else {
//            int m = amount / 2;
//            if (nums2.length==0){
//                return nums1[m];
//            }
//            int t1 = 0;
//            int t2 = 0;
//            double res = 0;
//            while (t1 + t2 <= m) {
//                if (t1 < nums1.length && nums1[t1] < nums2[t2]) {
//                    if (t1 + t2 == m) {
//                        res = nums1[t1];
//                    }
//                    t1++;
//                } else if (t2 < nums2.length){
//                    if (t1 + t2 == m) {
//                        res = nums2[t2];
//                    }
//                    t2++;
//                }else {
//                    if (t1 + t2 == m) {
//                        res = nums1[t1];
//                    }
//                    t1++;
//                }
//            }
//            return res;
//        }
//    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int amount = nums1.length+nums2.length;
        double l = 0;
        double r = 0;
        if (amount%2==0){
            l = amount/2 - 1;
            r = amount/2;
        }else {
            l = r = amount/2;
        }
        int t1 = 0;
        int t2 = 0;
        int lV = 0;
        int rV = 0;
        while (t1+t2 <= r){
            if (t2 >= nums2.length || (t1<nums1.length && nums1[t1]<nums2[t2])){
                if (t1+t2==l){
                    lV = nums1[t1];
                }
                if (t1 + t2 == r){
                    rV = nums1[t1];
                }
                t1++;
            }else if (t1 >= nums1.length || (t2<nums2.length && nums1[t1] >= nums2[t2])){
                if (t1+t2==l){
                    lV = nums2[t2];
                }
                if (t1 + t2 == r){
                    rV = nums2[t2];
                }
                t2++;
            }
        }
        return (lV+rV)/2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        int[] nums3 = {1, 2};
        int[] nums4 = {3};
        System.out.println(findMedianSortedArrays(nums3, nums4));
        int[] nums5 = {1};
        int[] nums6 = {3};
        System.out.println(findMedianSortedArrays(nums5, nums6));
        int[] nums7 = {};
        int[] nums8 = {3};
        System.out.println(findMedianSortedArrays(nums7, nums8));
    }
}
