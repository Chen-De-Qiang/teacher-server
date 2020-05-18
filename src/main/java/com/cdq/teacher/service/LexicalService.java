package com.cdq.teacher.service;

import com.cdq.teacher.entity.Lexical.LexResult;

import java.util.List;

public interface LexicalService {

    public List<LexResult> LexicalAnalysis(String content);

}
