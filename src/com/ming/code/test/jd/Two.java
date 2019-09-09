package com.ming.code.test.jd;

import com.sun.xml.internal.ws.api.databinding.MappingInfo;

import java.util.*;

class Node{
    String name;
    int value = 0;
    Node(String name,int value){
        this.name = name;
        this.value = value;
    }
}
public class Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n+2][n+2];
        List<Node> list = new ArrayList<>();
        Map<Integer,Integer> valueMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
//            Integer tmpA = valueMap.get(a);
//            if (tmpA){
//                valueMap.put(a,1);
//            }
//            valueMap.put(a,++tmpA);
//            Integer tmpB = valueMap.get(b);
//            valueMap.put(b,++tmpB);
            int x = a >= n ? b:a;
            int y = a >= n ? a-n:b-n;
            map[x][y] = ++map[x][y];
            map[n][y] = ++map[n+1][y];
            map[x][n] = ++map[x][n+1];
        }
        for (int i = 0; i < n; i++) {
            Node tmpY = new Node(String.valueOf(i),map[i][n+1]);
            Node tmpX = new Node(String.valueOf(i+n),map[n+1][i]);
            list.add(tmpX);
            list.add(tmpY);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value >= o2.value ? -1 : 1;
            }
        });

        System.out.println("");
    }
}
