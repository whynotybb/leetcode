package solutions.string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens={"2", "1", "+", "3", "*"};
        ReversePolishNotation reversePolishNotation=new ReversePolishNotation();
        System.out.println(reversePolishNotation.evalRPN(tokens));
    }
    private int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        Set<String> symbol=new HashSet<>();
        symbol.add("+");
        symbol.add("-");
        symbol.add("*");
        symbol.add("/");
        for (String token:tokens){
            if (symbol.contains(token)){
                //前面的两个元素出栈，计算出结果入栈
                String a= stack.pop();
                String b= stack.pop();
                int c=calculate(Integer.valueOf(b),Integer.valueOf(a),token);
                stack.add(c+"");
            }else {
                stack.add(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }
    private int calculate(int a,int b,String symbol){
        if ("+".equals(symbol)){
            return a+b;
        }
        else if ("-".equals(symbol))
            return a-b;
        else if ("*".equals(symbol))
            return a*b;
        else if ("/".equals(symbol))
            return a/b;
        else
            System.out.println("输入非法");
        return -1;
    }
}
