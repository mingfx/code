package com.ming.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class N22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<String> left = new Stack<>();
        while (n>0){
            left.add("(");
            n--;
        }
        generate(left,new Stack<>(),res,new StringBuilder());
        return res;
    }
    private void generate(Stack<String> left,Stack<String> right,List<String> res,StringBuilder sb){
        if (left.empty()&&right.empty()){
            res.add(sb.toString());
            return;
        }
        if (!left.empty()){
            Stack<String> tmpLeft = (Stack<String>) left.clone();
            Stack<String> tmpRight = (Stack<String>) right.clone();
            String str = tmpLeft.pop();
            sb.append(str);
            tmpRight.push(")");
            generate(tmpLeft,tmpRight,res,sb);
            sb.delete(sb.length()-1,sb.length());
        }
        if (!right.empty()){
            Stack<String> tmpRight = (Stack<String>) right.clone();
            String str = tmpRight.pop();
            sb.append(str);
            generate(left,tmpRight,res,sb);
            sb.delete(sb.length()-1,sb.length());
        }
    }

    public static void main(String[] args) {
        N22_GenerateParenthesis generateParenthesis = new N22_GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(4);
        for (String str :
                list) {
            System.out.println(str);
        }
    }
}
