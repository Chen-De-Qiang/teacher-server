package com.cdq.teacher.entity.Lexical.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FileReadUtil
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 17:32
 * @Version 1.0
 */
public class FileReadUtil {
    //一行行读取文件,将每一行存到到List中
    public static List<String> ReadSymbols(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        List<String> list = new ArrayList<>();
        while ((s = in.readLine()) != null) list.add(s);
        in.close();
        return list;
    }

    //得到添加行号后的代码,用于显示在界面上
    public static String GetCode(File file) throws IOException {
        int currentLine = 1;
        BufferedReader in = new BufferedReader(new FileReader(file));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(currentLine < 10 ? currentLine + "  |  " : currentLine + " |  ");  //对齐行号
            sb.append(s);
            sb.append("\n");
            currentLine++;
        }
        in.close();
        return sb.toString();
    }
}
