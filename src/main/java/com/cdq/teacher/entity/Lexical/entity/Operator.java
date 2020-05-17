package com.cdq.teacher.entity.Lexical.entity;

import java.util.List;

/**
 * @ClassName Operator
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 18:12
 * @Version 1.0
 */
public class Operator extends Token {
    private static List<String> operators;
    private static int TAG = 4;

    public Operator(String fileName) {
        super(fileName);
        operators = super.getTokens();
    }

    public List<String> getOperatorList() {
        return operators;
    }

    @Override
    public int getTAG() {
        return TAG;
    }

    @Override
    public String getDetail() {
        return "操作符";
    }
}
