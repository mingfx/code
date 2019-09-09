package com.ming.code.test;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * 30 20 35 40   距离
 * 20 18 25 30   电量
 * 50   总距离
 */
public class zhu0829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String disStr = sc.nextLine();
        String valStr = sc.nextLine();
        int amount = sc.nextInt();
        String[] diss = disStr.split(" ");
        String[] vals = valStr.split(" ");
        int n = diss.length;
        int[] disArr = new int[n+1];
        int[] valArr = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            disArr[i] = Integer.valueOf(diss[i-1]);
            valArr[i] = Integer.valueOf(vals[i-1]);
        }
        int[][] arr = new int[n+1][amount+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < amount+1; j++) {
                if (disArr[i]>j){
                    arr[i][j] = arr[i-1][j];
                }else {
                    arr[i][j] = Math.max(arr[i-1][j],arr[i-1][j-disArr[i]]+valArr[i]);
                }
            }
        }
        System.out.println(arr[n][amount]);
    }
}
/*
30 20 35 40
20 18 25 30
50
 */