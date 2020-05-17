package com.cdq.teacher.entity.Lexical.entity;

import com.cdq.teacher.entity.Lexical.util.FileReadUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Token
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 17:33
 * @Version 1.0
 */
public abstract class Token {
    private static List<String> tokens = new ArrayList<>();
    public Token() {
    }
    public Token(String fileName) {
        try {
            tokens = FileReadUtil.ReadSymbols(fileName);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " NOT FOUND!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected List<String> getTokens() {
        return tokens;
    }
    //返回识别码TAG
    public abstract int getTAG();
    //返回具体的类型
    public abstract String getDetail();
}
