package com.cdq.teacher.entity.Lexical.entity;

/**
 * @ClassName UnsignedNumber
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 18:13
 * @Version 1.0
 */
public class UnsignedNumber extends Token {
    private static int TAG = 3;

    @Override
    public int getTAG() {
        return TAG;
    }

    @Override
    public String getDetail() {
        return "无符号数字";
    }
}
