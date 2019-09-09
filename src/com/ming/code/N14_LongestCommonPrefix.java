package com.ming.code;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class N14_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length<=0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int t = 0;
        while (true) {
            if (t >= strs[0].length()){
                return sb.toString();
            }
            String tmp = "" + strs[0].charAt(t);
            for (int i = 0; i < strs.length; i++) {
                if (t >= strs[i].length()){
                    return sb.toString();
                }
                if (!(""+strs[i].charAt(t)).equals(tmp)){
                    return sb.toString();
                }
            }
            sb.append(tmp);
            t++;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        String[] strs1 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs1));
        String[] strs2 = {"","flow","flight"};
        System.out.println(longestCommonPrefix(strs2));
    }
}
