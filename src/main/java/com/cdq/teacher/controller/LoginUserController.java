package com.cdq.teacher.controller;

import com.cdq.teacher.entity.User;
import com.cdq.teacher.global.Result;
import com.cdq.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginUserController {

    @Autowired
    UserService userService;


    @GetMapping(value = "/getUser")
    public Result loginUser(User record){
        Result result=new Result();
        result.setData(userService.selectUserInfo(record));
        record.setCurrentPage(null);
        record.setPageSize(null);
        result.setTotalCount(userService.selectUserInfo(record).size());
        return result;
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
    @PostMapping(value = "/addStudent")
    public Result addStudent(@RequestBody User user){
        return new Result(userService.addUserInfo(user));
    }

    /**
     * 删除某个人——通过姓名
     */
    @GetMapping(value = "/deleteUser")
    public Result deleteUser(@RequestParam("UserId") String UserId){
        return new Result(userService.deleteUser(UserId));
    }

    /**
     * 修改某人——通过姓名
     */
    @PostMapping(value = "/modifyUser")
    public Result modifyUser(@RequestBody User user){
        return new Result(userService.modifyUser(user));
    }


}
