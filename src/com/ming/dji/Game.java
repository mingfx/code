package com.ming.dji;

import java.util.*;

class MyGame{
    int value = 0;
    int time = 0;

    public MyGame(int value, int time) {
        this.value = value;
        this.time = time;
    }
}
public class Game {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            int N = sc.nextInt();
//            int X = sc.nextInt();
//            List<MyGame> games = new ArrayList<>();
//            for (int j = 0; j < N; j++) {
//                int value = sc.nextInt();
//                int time = sc.nextInt();
//                games.add(new MyGame(value,time));
//            }
//            Collections.sort(games, new Comparator<MyGame>() {
//                @Override
//                public int compare(MyGame o1, MyGame o2) {
//                    double rate1 = o1.value/(double)o1.time;
//                    double rate2 = o2.value/(double)o2.time;
//                    if (rate1 > rate2) {
//                        return -1;
//                    } else
//                        return 1;
//                }
//            });
//            int leftTime = X;
//            int k = 0;
//            int sum = 0;
//            int t = 0;
//            while (leftTime != 0){
//                if (t >= games.size()){
//                    break;
//                }
//                if (k >= games.size()){
//                    MyGame tmp = games.get(t);
//                    sum -= tmp.value;
//                    leftTime += tmp.time;
//                    t++;
//                    k = t;
//                    continue;
//                }
//                MyGame tmp = games.get(k);
//                if (leftTime >= tmp.time) {
//                    sum += tmp.value;
//                    leftTime = leftTime - tmp.time;
//                }
//                k++;
//            }
//            System.out.println(sum);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int X = sc.nextInt();
            int[] value = new int[N];
            int[] time = new int[N];
            for (int j = 0; j < N; j++) {
                value[j] = sc.nextInt();
                time[j] = sc.nextInt();
            }
            int amount = table(X,time,value);

            System.out.println(amount);
        }
    }

    public static int OneZeroBag(int[] time, int[] value, int X){
        int n = time.length;
        int[][] table = new int[n+1][X+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= X; j++) {

            }
        }
        return 0;
    }

    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] table = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) { //物品
            for (int j = 1; j <= w; j++) {  //背包大小
                if (weight[i] > j) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    table[i][j] = table[i - 1][j];
                    // System.out.print(table[i][j]+ " ");
                } else { //装得下，Max{装物品i， 不装物品i}
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                    //System.out.print(table[i][j]+ " ");
                }
            }
            // System.out.println();
        }
        return table[n][w];
    }

    static int table(int pag,int[] w,int[] p) {
        int n = w.length;
        //初始化f[0][1~pag]=0;f[1-n][o]=0;这样才能根据初始化根据公式推算其他的值！
        int[][] f = new int[n + 1][pag + 1];
        //01背包算法f[i][j]=MAX{f[i-1][j-w[i]]+p[i](j>=w[i],f[i-1][j])}
        //算法核心部分：根据公式进行推算！！！！！
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= pag; j++) {
                if (j >= w[i - 1]) {
                    f[i][j] = Math.max(f[i - 1][j - w[i - 1]] + p[i - 1], f[i - 1][j]);
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[n][pag];
    }
}
