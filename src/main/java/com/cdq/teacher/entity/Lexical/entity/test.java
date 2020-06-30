package com.cdq.teacher.entity.Lexical.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName test
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/6/26 20:06
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) {
        String str = "成都市(成华区)(武侯区)(高新区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    }
}
