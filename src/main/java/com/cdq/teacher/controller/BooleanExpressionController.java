package com.cdq.teacher.controller;

import com.cdq.teacher.global.Result;
import com.cdq.teacher.service.BooleanExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @ClassName BooleanExpressionUtil
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/20 8:07
 * @Version 1.0
 */
@CrossOrigin
@RestController
public class BooleanExpressionController {
    @Autowired
    BooleanExpService booleanExpService;

    @PostMapping("/BooleanExpression")
    public Result BooleanExpression(@RequestBody String content){

        try {
            String deurl = URLDecoder.decode(content,"UTF-8");
            System.out.println(deurl);
            return new Result(booleanExpService.parseBoolExpr(deurl));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
