package com.ming.code;

import java.util.Arrays;
import java.util.Optional;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class N10_IsMatch {
    public static boolean isMatch(String s, String p) {
        for (int i = 1;p.length()>1 && i < p.length(); i++) {
            if ((""+p.charAt(i-1)).equals(""+p.charAt(i))){
                if ((""+p.charAt(i)).equals("*")){
                    p = p.substring(0,i)+p.substring(i+1);
                }else
                    p = p.substring(0,i)+"*"+p.substring(i+1);
            }
        }

        String[] strs = p.split("\\*");
        int i = 0;
        int j = 0;
        int k = 0;
        String last = "";
        while (i<s.length()) {

            String tmp = strs[j];
            if ("".equals(tmp))
                return false;
            if ((""+tmp.charAt(k)).equals("*")){

                if ((""+s.charAt(i)).equals(last)||last.equals(".")){
                    i++;
                }else {
                    //return false;
                    k++;
                }
            }else {
                if ((""+s.charAt(i)).equals(""+tmp.charAt(k))||(""+tmp.charAt(k)).equals(".")){
                    i++;
                    k++;
                }else {
                    return false;
                }
            }

            if (k == tmp.length()){
                j++;
                last = "" + tmp.charAt(tmp.length()-1);
                k = 0;
            }
        }
        if (k!=strs[j-1].length()-1){
            return false;
        }
        return true;
    }

    public static boolean isMatch2(String s, String p) {
        int i = 0;
        int j = 0;
        String last = "";
        boolean isStar = false;
        boolean isPoint = false;
        while (i<s.length()){
            if ("*".equals(""+p.charAt(j))){
                isStar = true;
                if (j>1 && ".".equals(""+p.charAt(j-1))){
                    isPoint = true;
                }
            }
            if (isStar){
                if ((""+s.charAt(i-1)).equals(""+s.charAt(i))||isPoint){
                    i++;
                }else {
                    isStar = false;
                    j++;
                }
            }
            if (!isStar){
                if (isEqual(s,i,p,j)){
                    i++;
                    j++;
                }else {
                    return false;
                }
            }
            if (j>p.length()){
                return false;
            }
        }
        return true;
    }

    public static boolean isMatch3(String s, String p) {
        int i = 0;
        int j = 0;
        String last = "";
        while (i<s.length()){
            if ("".equals(last)){
                if (j>=p.length()){
                    return false;
                }
                if (j<p.length()-1&&"*".equals(""+p.charAt(j+1))){
                    last = ""+p.charAt(j);
                }else {
                    if (isEqual(s,i,p,j)){
                        i++;
                        j++;
                    }else
                        return false;
                }
            }else if (".".equals(last)){
                i++;
                if (i==s.length()){
                    j = j+2;
                }
            }else {
                if (last.equals(""+s.charAt(i))){
                    i++;
                    if (i==s.length()){
                        j = j+2;
                    }
                }else {
                    last = "";
                    j = j+2;
                }
            }
        }
        if (last.equals(".")){
            while (j+1<p.length()){
                if ("*".equals(""+p.charAt(j+1))){
                    j = j+2;
                }else
                    break;
            }
        }
        if (i==s.length()&&j==p.length()||i>0&&last.equals(""+s.charAt(i-1))||Con1Euqal(p,j)){
            return true;
        }else
            return false;
    }

    private static boolean isEqual(String s, int i, String p, int j) {
        return (""+s.charAt(i)).equals(""+p.charAt(j))||".".equals(""+p.charAt(j));
    }

    private static boolean Con1Euqal(String p,int j){

        for (int i = j; i < p.length(); i = i+2) {
            if (i+1<p.length()){
                if (!"*".equals(""+p.charAt(i+1))){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "mis*is*p*.";
        String[] strs = str.split("\\*");
        System.out.println(Arrays.toString(strs));
        String tar = "mississppi";
        System.out.println(isMatch3(tar,str));
        String str1 = "aab";
        String tar1 = "c*a*b";
        System.out.println(isMatch3(str1,tar1));
        String str2 = "aab";
        String tar2 = ".*";
        System.out.println(isMatch3(str2,tar2));
        String str3 = "bba";
        String tar3 = ".*a*a";
        System.out.println(isMatch3(str3,tar3));
        String str4 = "a";
        String tar4 = ".";
        System.out.println(isMatch3(str4,tar4));
        String str5 = "";
        String tar5 = "";
        System.out.println(isMatch3(str5,tar5));
        String str6 = "ab*c*a";
        System.out.println(Con1Euqal(str6,1));
        final String jack = "jack";

    }
}
