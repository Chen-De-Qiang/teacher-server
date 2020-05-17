package com.cdq.teacher.entity.Lexical.entity;

/**
 * @ClassName Identifier
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 18:09
 * @Version 1.0
 */
public class Identifier extends Token {
    private static int TAG = 2;

    @Override
    public int getTAG() {
        return TAG;
    }

    @Override
    public String getDetail() {
        return "标识符";
    }

}
