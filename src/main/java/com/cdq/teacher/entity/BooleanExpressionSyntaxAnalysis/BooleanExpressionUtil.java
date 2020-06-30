package com.cdq.teacher.entity.BooleanExpressionSyntaxAnalysis;

import java.util.Stack;

/**
 * @ClassName BooleanExpressionUtil
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/19 16:11
 * @Version 1.0
 */
public class BooleanExpressionUtil {
    public static boolean parseBoolExpr(char[] expression){

        Stack<Character> ops = new Stack<>();
        Stack<Character> exps = new Stack<>();
        for(Character c: expression){
            if(c=='!'|| c=='&' || c=='|'){
                ops.push(c);
            }else if (c=='t' || c=='f'||c=='('){
                exps.push(c);
            }else if (c==')'){
                boolean t=false,f=false;
                while (exps.peek()!='('){
                    char exp=exps.peek();
                    exps.pop();
                    if (exp=='t')
                        t=true;
                    else
                        f=true;
                }
                exps.pop();//弹出"("
                char op=ops.peek();
                ops.pop();
                if (op=='&'){
                    exps.push(f?'f':'t');//只要出现false结果就是false
                }else if(op=='|'){
                    exps.push(t?'t':'f');//只要出现true结果就是true
                }else if(op=='!'){
                    exps.push(f?'t':'f');//出现false结果就是true
                }
            }
        }
        return exps.peek().equals('t');
    }

    public static void main(String[] args) {
        String stringTrue="|(f,t)";
        String string="|(&(t,f,t),!(t))";
        char [] stringArr = stringTrue.toCharArray();
        System.out.println(parseBoolExpr(stringArr));
    }
}
