package com.cdq.teacher.entity.Lexical.entity;

import java.util.List;

/**
 * @ClassName Separator
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 18:12
 * @Version 1.0
 */
public class Separator extends Token {
    private static List<String> separator;
    private static int TAG = 5;

    public Separator(String fileName) {
        super(fileName);
        separator = super.getTokens();
    }

    public List<String> getSeparatorList() {
        return separator;
    }

    @Override
    public int getTAG() {
        return TAG;
    }

    @Override
    public String getDetail() {
        return "分隔符";
    }
}
