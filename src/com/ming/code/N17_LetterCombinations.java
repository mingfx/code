package com.ming.code;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2:abc
 * 3:def
 * 4:ghi
 * 5:jkl
 * 6:mno
 * 7:pqrs
 * 8:tuv
 * 9:wxyz
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
public class N17_LetterCombinations {
    public static List<String> letterCombinations(String str){
        Map<String,List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a","b","c"));
        map.put("3", Arrays.asList("d","e","f"));
        map.put("4", Arrays.asList("g","h","i"));
        map.put("5", Arrays.asList("j","k","l"));
        map.put("6", Arrays.asList("m","n","o"));
        map.put("7", Arrays.asList("p","q","r","s"));
        map.put("8", Arrays.asList("t","u","v"));
        map.put("9", Arrays.asList("w","x","y","z"));

        List<String> res = new ArrayList<>();
        if(null == str || "".equals(str)){
            return res;
        }
        ss(str,0,map,new StringBuilder(),res);
        return res;
    }

    private static void ss(String str, int i, Map<String,List<String>> map,StringBuilder sb,List<String> res){
        if (i>=str.length()){
            res.add(sb.toString());
            return;
        }
        if (str.charAt(i)>= '2' && str.charAt(i) <= '9') {
            String tmp = "" + str.charAt(i);
            List<String> list = map.get(tmp);
            for (int j = 0; j < list.size(); j++) {
                String cur = list.get(j);
                sb.append(cur);
                ss(str,i+1,map,sb,res);
                sb.delete(sb.length()-1,sb.length());
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("234");
        System.out.println(Arrays.toString(list.toArray()));
    }
}
