package com.ming.code.test.jd;

import java.util.Scanner;

public class One {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] arr = new int[N+1];
//        int res = new int[1000000000000*N];
//
//
//    }
}


//M = int(input())
//        W = list(map(int,input().split()))
//        houzhui = [1000000000000] * M
//        houzhui[-1] = W[-1]
//         = [0] * M
//        qianzhui[0] = W[0]
//        for i in range(M-2,-1,-1):
//        if W[i] < houzhui[i+1]:
//        houzhui[i] = W[i]
//        else:
//        houzhui[i] = houzhui[i+1]
//        for i in range(1,M):
//        if W[i] > qianzhui[i-1]:
//        qianzhui[i] = W[i]
//        else:
//        qianzhui[i] = qianzhui[i-1]
//        houzhui.append(0)
//        qianzhui.insert(0,0)
//        res = 0
//        for i in range(M+1):
//        if qianzhui[i] <= houzhui[i]:
//        res += 1
//        print(res)