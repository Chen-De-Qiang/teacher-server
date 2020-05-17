package com.cdq.teacher.entity.Lexical.entity;

import java.util.List;

/**
 * @ClassName KeyWord
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 18:11
 * @Version 1.0
 */
public class KeyWord extends Token {
    private static List<String> keyWords;
    private static int TAG = 1;

    public KeyWord(String fileName) {
        super(fileName);
        keyWords = super.getTokens();
    }

    public List<String> getKeywordList() {
        return keyWords;
    }

    @Override
    public int getTAG() {
        return TAG;
    }

    @Override
    public String getDetail() {
        return "保留字";
    }
}
