package com.ming.code;

public class MultiString {
    //xie cuo le
    public static String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int last = 0;
        while (last!=0||!"".equals(num1)||!"".equals(num2)) {
            if ("".equals(num1)) {
                num1 = "0";
            }
            if ("".equals(num2)) {
                num2 = "0";
            }
            int a = Integer.valueOf("" + num1.charAt(num1.length() - 1));
            int b = Integer.valueOf("" + num2.charAt(num2.length() - 1));
            int amount = a * b + last;
            if (amount > 9) {
                last = amount / 10;
                amount = amount % 10;
            } else {
                last = 0;
            }
            res.insert(0,amount);
            num1 = num1.substring(0, num1.length() - 1);
            num2 = num2.substring(0, num2.length() - 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str1 = "3154";
        String str2 = "2210";
        System.out.println(multiply(str1, str2));
    }
}
