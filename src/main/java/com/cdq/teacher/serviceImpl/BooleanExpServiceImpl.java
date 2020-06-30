package com.cdq.teacher.serviceImpl;

import com.cdq.teacher.entity.BooleanExpressionSyntaxAnalysis.BooleanExpressionUtil;
import com.cdq.teacher.service.BooleanExpService;
import org.springframework.stereotype.Service;

/**
 * @ClassName BooleanExpServiceImpl
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/20 8:14
 * @Version 1.0
 */
@Service
public class BooleanExpServiceImpl implements BooleanExpService {
    @Override
    public Boolean parseBoolExpr(String string) {
        if(string==null){
            return false;
        }
        string=string.substring(1,string.length()-5);
        char[] chars=string.toCharArray();

        return BooleanExpressionUtil.parseBoolExpr(chars);
    }
}
