package com.ming.code;

public class N50_MyPow {
    public static double myPow1(double x, int n) {
        int m = Math.abs(n);
        int flag = 1;
        double res = 1;
        while (flag <= m){
            if ((flag & m) == flag){
                res = res * x;
            }
            x = x * x;
            flag = flag * 2;
        }
        return n >= 0 ? res : 1/res;
    }

    public static double myPow(double x, int n) {
        long m = Math.abs((long)n);
        double res = 1;
        while (m != 0){
            if ((m & 1) == 1){
                res = res * x;
            }
            x = x * x;
            m = m >> 1;
        }
        return n >= 0 ? res : 1/res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
}
