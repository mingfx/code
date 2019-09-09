package com.ming.code.test.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        int amount1 = 0;
        int amount2 = 0;
        for (int i = min; i < max; i += 2) {
            if (i%2==0){
                i++;
            }
            int temp = (int) Math.sqrt(i);
            boolean signal = true;
            for (int j = 3; j <= temp; j += 2) {
                if (i % j == 0) {
                    signal = false;
                    break;
                }
            }
            if (signal) {
                amount1 += i% 10;
                amount2 += (i% 100 - i % 10)/10;
            }
        }
        int res = Math.min(amount1,amount2);
        System.out.println(res);
    }
}
