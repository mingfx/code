package com.ming.code;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * abcabcbb  3
 * aaaa      1
 * pwwkew    3
 */

public class N3_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)||s==null){
            return 0;
        }
        int l = 0;
        int r = 1;
        int len = 1;
        while (r < s.length()){
            for (int i = l; i < r; i++) {
                if ((""+s.charAt(i)).equals(""+s.charAt(r))){
                    l = i+1;
                    //r = r+1;
                    break;
                }
            }
            r++;
            len = len > r - l ? len : r-l;
        }
        return len;
    }

    public static void main(String[] args) {
        String s1 = "aaaaabcccaa";
        System.out.println(lengthOfLongestSubstring(s1));
        String s2 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s2));
        String s3 = "dvdf";
        System.out.println(lengthOfLongestSubstring(s3));
        String s4 = "";
        System.out.println(lengthOfLongestSubstring(s4));
        String s5 = "a";
        System.out.println(lengthOfLongestSubstring(s5));
    }
}
