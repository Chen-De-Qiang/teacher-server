package com.cdq.teacher.controller;

import com.cdq.teacher.global.Result;
import com.cdq.teacher.service.LexicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @ClassName LexicalController
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 15:52
 * @Version 1.0
 */
@CrossOrigin
@RestController
public class LexicalController {

    @Autowired
    LexicalService lexicalService;

    @PostMapping("/Lexical")
    public Result LexicalAnalysis(@RequestBody String content){

        try {
            String deurl = URLDecoder.decode(content,"UTF-8");
            System.out.println(deurl);
            return new Result(lexicalService.LexicalAnalysis(deurl));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
