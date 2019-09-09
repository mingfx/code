package com.ming.code.test.jd;

import java.util.Scanner;


public class Two_2 {
    static int[][] test;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] resArr = new int[2 * N + 1];
        int len = 2 * N + 1;
        test = new int[len][len];
        for (int i = 0; i < M; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            test[a][b] = 1;
        }
        in.close();
        while (check(len)) {
            for (int i = 0; i < len; i++) {
                int temp = 0;
                for (int j = 0; j < len; j++) {
                    if (test[i][j] == 1) {
                        temp++;
                    }
                }
                if (temp > 0) {
                    resArr[i] = 1;
                    clear(i, len);
                }
            }
        }
        int res = 0;
        for (int j = 0; j < len; j++) {
            if (resArr[j] == 1) {
                res++;
            }

        }
        System.out.println(res);
        for (int j = 0; j < len; j++) {
            if (resArr[j] == 1) {
                System.out.println(j);
            }

        }
    }

    private static boolean check(int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (test[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void clear(int k, int len) {
        for (int i = 0; i < len; i++) {
            test[k][i] = 0;
        }
        for (int j = 0; j < len; j++) {
            test[j][k] = 0;
        }
    }
}