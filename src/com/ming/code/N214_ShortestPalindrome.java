package com.ming.code;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 */
//我是不停的试探，如果错了，就返回上一次添加的位置。
//时间复杂度过不去，不知道为啥。。。应该要用dp才可以吧，把试探过的保存下来。
public class N214_ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int p = 0;
        int q = sb.length()-1;
        int curInsertIndex = 0;
        while (p<=q){
            if ((sb.charAt(q)+"").equals(sb.charAt(p)+"")){
                p++;
            }else {
                p = curInsertIndex;
                q = sb.length() - 1 - curInsertIndex;
                sb.insert(p,sb.charAt(q)+"");
                p++;
                q++;
                curInsertIndex++;
            }
            q--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String src = "aacecaaa";
        System.out.println(shortestPalindrome(src));
        String src1 = "aabba";
        System.out.println(shortestPalindrome(src1));
        String src2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(shortestPalindrome(src2));
    }
}
