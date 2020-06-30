package com.cdq.teacher.serviceImpl;

import com.cdq.teacher.entity.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName AuthenticationAccessDeniedHandler
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/6/30 11:14
 * @Version 1.0
 */
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response. setStatus (HttpServletResponse. SC_FORBIDDEN) ;
        response. setContentType ("application/json; charset=UTF-8") ;
        PrintWriter out = response.getWriter() ;
        RespBean
                error = RespBean.error ("权限不足，请联系管理员!");
        out. write (new ObjectMapper() .writeValueAsString (error));
        out. flush() ;
        out.close() ;

    }
}
