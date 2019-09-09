package com.ming.code;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class N6_ZConvert {
    public static String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        int stepM = numRows*2-2;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int step = stepM;
        for (int i = 0; i < numRows; i++) {
            step = stepM - 2*i;
            if (step == 0){
                step = stepM;
            }
            index = i;
            while (index<s.length()){
                sb.append(s.charAt(index));
                index += step;
                if (step!=stepM){
                    step = stepM - step;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        String strTar1 = "LCIRETOESIIGEDHN";
        System.out.println(strTar1);
        System.out.println(convert(str,3));
        String strTar2 = "LDREOEIIECIHNTSG";
        System.out.println(strTar2);
        System.out.println(convert(str,4));
        System.out.println(convert(str,2));
        System.out.println(convert(str,1));
    }
}