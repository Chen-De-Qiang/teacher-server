package com.cdq.teacher.serviceImpl;

import com.cdq.teacher.entity.Lexical.LexResult;
import com.cdq.teacher.entity.Lexical.util.LexerUtil;
import com.cdq.teacher.service.LexicalService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LexicalService
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 16:14
 * @Version 1.0
 */
@Service
public class LexicalServiceImpl implements LexicalService {
    @Override
    public int LexicalAnalysis(String content) {
//        防止为空
        if(content==null){
            return 0;
        }
//        去掉双引号
        String string=content.replace("\"","");
//        分割换行符
        String[] strings=string.split("\\\\n");
        List<LexResult> list=LexerUtil.LexicalAnalysis(strings);
        for (LexResult lexResult:list) {
            System.out.println(lexResult);
        }
        return 0;
    }
}
