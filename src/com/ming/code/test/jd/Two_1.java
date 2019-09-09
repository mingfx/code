package com.ming.code.test.jd;




        import java.util.ArrayList;
        import java.util.Scanner;

public class Two_1 {

    public static int maxVal(int[] arr){
        int val=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                val=i;
                max=arr[i];
            }
        }
        return val;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        int tmpVal=0;
        int[] arr=new int[n*2];
        int[][] map=new int[n*2][n*2];
        for(int i=0;i<m;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            arr[a]++;
            arr[b]++;
            map[a][b]=1;
            map[b][a]=1;
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(tmpVal<m){
            int v;
            v=maxVal(arr);
            res.add(v+1);
            tmpVal+= arr[maxVal(arr)];
            for(int i=0;i<n;i++){
                if(map[v][i]==1){
                    arr[i]--;
                    map[v][i]=0;
                    map[i][v]=0;
                }
            }
        }
        System.out.println(res.size());
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }

    }

}