package com.ming.code;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 * attention:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class N7_ReverseInt {
    public static int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(str.length()-i-1));
        }

        try {
            if (x<0){
                return -Integer.valueOf(sb.substring(0,sb.length()-1));
            }else {
                int res = Integer.valueOf(sb.toString());
                return res;
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(Integer.parseInt("1534236469"));
        System.out.println(reverse(1534236469));
    }
}