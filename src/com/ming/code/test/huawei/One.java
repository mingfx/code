package com.ming.code.test.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstMan = scanner.nextLine();
        int nums = scanner.nextInt();
        String[] total = new String[nums + 1];
        for (int i = 0; i < nums + 1; i++) {
            total[i] = scanner.nextLine();
        }
        int length = total.length;
        int amount = 0;
        if (length < 1) {
            System.out.println(amount);
            return;
        }
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int z = 0; z < length; z++) {
            for (String allPerson : total) {
                String[] everyGroup = allPerson.split(",");
                for (int j = 0; j < everyGroup.length; j++) {
                    if (everyGroup[j].equals(firstMan) || hashMap.containsKey(everyGroup[j])) {
                        for (int k = 0; k < everyGroup.length; k++) {
                            if (!hashMap.containsKey(everyGroup[k])) {
                                hashMap.put(everyGroup[k], 1);
                                amount++;
                            }
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(amount);
    }
}
//    public static int result(String firstPeople, String[] allPeople) {
//        int length = allPeople.length;
//        int total = 0;
//        if (length < 1) return 0;
//        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
//        for (int z = 0; z < length; z++) {
//            for (String allPerson : allPeople) {
//                String[] everyGroup = allPerson.split(",");
//                for (int j = 0; j < everyGroup.length; j++) {
//                    if (everyGroup[j].equals(firstPeople) || hashMap.containsKey(everyGroup[j])) {
//                        for (int k = 0; k < everyGroup.length; k++) {
//                            if (!hashMap.containsKey(everyGroup[k])) {
//                                hashMap.put(everyGroup[k], 1);
//                                total++;
//                            }
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//        return total;
//    }


