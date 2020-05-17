package com.cdq.teacher.entity.Lexical.util;

import com.cdq.teacher.entity.Lexical.LexResult;
import com.cdq.teacher.entity.Lexical.entity.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LexerUtil
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 17:14
 * @Version 1.0
 */
public class LexerUtil {
    private final static String KEYWORD_PATH = "src/main/resources/keywords.txt";
    private final static String OPERATOR_PATH = "src/main/resources/operators.txt";
    private final static String SEPARATOR_PATH = "src/main/resources/separators.txt";
    private final static KeyWord keyWord = new KeyWord(KEYWORD_PATH);
    private final static Operator operator = new Operator(OPERATOR_PATH);
    private final static Separator separator = new Separator(SEPARATOR_PATH);
    private final static UnsignedNumber unsignedNumber = new UnsignedNumber();
    private final static Identifier identifier = new Identifier();

    public static List<LexResult> LexicalAnalysis(String[] strings) {
        int currentLine = 1;//用于保存该字符的行号
        List<LexResult> lexResultList = new ArrayList<>();
        //            BufferedReader in = new BufferedReader(new FileReader(file));
        String s;
        List<String> list;
        for(int i=0;i<strings.length&&strings[i]!=null;i++){
                list = division(strings[i]); //分割字符
            for (String symbol : list) {
                //用于判断当前字符属于哪种符号
                Token currentType;
                if      (isKeyWord(symbol))     currentType = keyWord;
                else if (isOperator(symbol))    currentType = operator;
                else if (isSeparator(symbol))   currentType = separator;
                    //若不是关键字,操作符,分隔符,将该字符强转为Integer类型
                    //抛出异常，表明该字符为标识符
                    //不抛出异常，表面该字符为无符号数
                else {
                    try {
                        Integer.valueOf(symbol);
                        currentType = unsignedNumber;
                    } catch (NumberFormatException e) {
                        currentType = identifier;
                    }
                }
                LexResult lexResult = new LexResult(String.valueOf(currentLine),
                        symbol, String.valueOf(currentType.getTAG()), currentType.getDetail());
                lexResultList.add(lexResult);
            }
            currentLine++;
        }
        return lexResultList;
    }

    /**
     * 1.将字符串转化为字符数组,定义一个StringBuilder对象用来保存符号
     * 2.遍历字符数组,进行如下操作:
     *      if(字符 == 操作符 || 分隔符 || 空格) --> 从该字符分割
     *          if(StringBuilder长度不为0)-->将StringBuilder取出所有空格后存入List
     *          if(字符 == 空格) --> 将空格存入List
     *          清空StringBuilder;
     *          continue;
     *      else --> StringBuilder后添加该字符
     *
     * @param s 一行语句
     * @return 一行行中分割后的字符列表
     */
    private static List<String> division(String s) {
        char[] chars = s.trim().toCharArray();  //去除首尾空格并转化为字符数组
        List<String> list = new ArrayList<>();  //保存组合出的单词和字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (isOperator(String.valueOf(chars[i]))
                    || isSeparator(String.valueOf(chars[i]))
                    || chars[i] == ' ') {
                if (sb.length() != 0) list.add(sb.toString().replaceAll(" ", ""));
                if (chars[i] != ' ') list.add(String.valueOf(chars[i]));
                sb.delete(0, sb.length());  //清空StringBuilder
                continue;
            }
            sb.append(chars[i]);
        }
        return list;
    }

    private static boolean isKeyWord(String s) {
        return keyWord.getKeywordList().contains(s);
    }
    private static boolean isOperator(String s) {
        return operator.getOperatorList().contains(s);
    }
    private static boolean isSeparator(String s) {
        return separator.getSeparatorList().contains(s);
    }
}
