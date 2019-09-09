package com.ming.code;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class N20_IsValid {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String tmp = ""+s.charAt(i);
            if ("(".equals(tmp)||"{".equals(tmp)||"[".equals(tmp)){
                stack.push(tmp);
            }else if (")".equals(tmp)){
                if (stack.empty()||!stack.pop().equals("(")){
                    return false;
                }
            }else if ("}".equals(tmp)){
                if (stack.empty()||!stack.pop().equals("{")){
                    return false;
                }
            } else if ("]".equals(tmp)) {
                if (stack.empty()||!stack.pop().equals("[")){
                    return false;
                }
            }

        }

        if (stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "[{[][]}]][]";
        N20_IsValid isValid = new N20_IsValid();
        System.out.println(isValid.isValid(str));
    }
}