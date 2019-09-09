package com.ming.code;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class N12_IntToRoman {
    public static String intToRoman(int num) {
        int[] arr1 = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        int[] arr = {1,10,100,1000};
        String[][] str = {{"I","V"},{"X","L"},{"C","D"},{"M",""}};
        int res = num;
        StringBuilder sb = new StringBuilder();
        int i = arr.length - 1;
        while (res > 0 && i >= 0){
            int tmp = arr[i];
            int rate = res / tmp;
            if (rate == 9){
                sb.append(str[i][0]);
                sb.append(str[i+1][0]);
            }else if (rate >= 5){
                sb.append(str[i][1]);
                for (int j = 0; j < rate - 5; j++) {
                    sb.append(str[i][0]);
                }
            }else if (rate == 4){
                sb.append(str[i][0]);
                sb.append(str[i][1]);
            }else if (rate > 0){
                for (int j = 0; j < rate; j++) {
                    sb.append(str[i][0]);
                }
            }
            res = res % tmp;
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(5));
        System.out.println(intToRoman(19));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

    }
}
