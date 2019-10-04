package com.cdq.teacher.controller;

import com.cdq.teacher.entity.User;
import com.cdq.teacher.global.Result;
import com.cdq.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginUserController {

    @Autowired
    UserService userService;

    /**
     * 搜索人——通过姓名
     */
    @GetMapping(value = "/loginUser")
    public Result loginUser(@RequestParam("userName") String userName){
        return new Result(userService.selectUserInfoFile(userName));
    }

    /**
     * 搜索全部人的名字
     */
    @GetMapping(value = "/getAllUser")
    public Result getAllUser(){
        return new Result(userService.getAllUserMQL());
    }

    /**
     * 注册用户
     */
    @GetMapping(value = "/addStudent")
    public Result addStudent(User user){
        return new Result(userService.inputUserInfoFile(user));
    }

    /**
     * 删除某个人——通过姓名
     */
    @GetMapping(value = "/deleteUser")
    public Result deleteUser(@RequestParam("userName") String userName){
        return new Result(userService.deleteUserFlie(userName));
    }

    /**
     * 修改某人——通过姓名
     */
    @GetMapping(value = "/modifyUser")
    public Result modifyUser(User user){
        return new Result(userService.modifyUserFlie(user));
    }


}
