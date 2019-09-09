package com.ming.code;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class N5_LongestPalindrome {
    //中心拓展法
    public static String longestPalindrome(String s) {
        if (s==null||"".equals(s)){
            return "";
        }
        int maxC = -1;
        int maxL = -1;
        for (int i = 0; i < s.length(); i++) {
            int t = 0;
            while (i - t >= 0 && i + t < s.length()) {
                if (!("" + s.charAt(i - t)).equals("" + s.charAt(i + t))) {
                    break;
                }
                t++;
            }
            if (t > maxL) {
                maxC = i;
                maxL = t - 1;
            }
        }
        return s.substring(maxC - maxL, maxC + maxL + 1);
    }

    //manacher 算法
    public static String longestPalindrome2(String s) {

        String T = addSharp(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
            } else {
                P[i] = 0;// 等于 R 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法   //不会越界，因为末尾是$
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

        }

        // 找出 P 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }

    private static String addSharp(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.charAt(i);
        ret += "#$";
        return ret;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
        String str2 = "babfbab";
        System.out.println(longestPalindrome(str2));
        String str3= "";
        System.out.println(longestPalindrome(str3));
        String str4= "a";
        System.out.println(longestPalindrome(str4));

//        StringBuilder sb = new StringBuilder("aaaa");
//        System.out.println(sb.insert(sb.length(),"$").toString());

        System.out.println("---------------------------");
        System.out.println(longestPalindrome2(str));
        System.out.println(longestPalindrome2(str2));
        System.out.println(longestPalindrome2(str3));
        System.out.println(longestPalindrome2(str4));

        //String str5 = "abaca";
        //System.out.println(str4.charAt(1));
    }

}
