package com.cdq.teacher.controller;

import com.cdq.teacher.entity.User;
import com.cdq.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginUserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/loginUser")
    public User loginUser(){
        return userService.selectUserInfo("1");
    }




}
