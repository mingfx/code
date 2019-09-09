package com.ming.code.test.huawei;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] msg = line.split(" ");
        StringBuilder sb = new StringBuilder();
        if ("".equals(msg[0])){
            System.out.println("");
            return;
        }
        int count = Integer.valueOf(msg[0]);
        if (count>127){
            return;
        }

        int resCount = count;
        for (int i = 1; i < count; i++) {
            String tmp = msg[i].toUpperCase();
            if (tmp.equals("A")){
                sb.append("12 34 ");
                resCount++;
            }else if (tmp.equals("B")){
                sb.append("AB CD ");
                resCount++;
            }else {
                sb.append(tmp+" ");
            }
        }
        String res = sb.toString();
        if (resCount == 1){
            System.out.println("1");
        }else
        System.out.println(String.valueOf(resCount) +" "+ res.substring(0,res.length()-1));
    }
}
