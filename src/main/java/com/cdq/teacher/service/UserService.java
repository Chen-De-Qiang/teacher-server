package com.cdq.teacher.service;

import com.cdq.teacher.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 根据id查询用户所有的信息
     */
    User selectUserInfo(String userName);

    /**
     * 通过用户名称查询用户
     * @param userName
     * @return
     */
    User selectUserInfoFile(String userName);

    /**
     * 获得所有的用户
     */
    List<User> getAllUser();

    boolean inputUserInfoFile(User user);

    boolean deleteUserFlie(String UserName);

    boolean modifyUserFlie(User user);

    List<User> getAllUserMQL();

    boolean addUserInfo(User user);

    boolean deleteUser(String UserName);

    boolean modifyUser(User user);
}
