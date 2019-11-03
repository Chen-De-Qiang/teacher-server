package com.cdq.teacher.mapper;

import com.cdq.teacher.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser(User record);

    List<User> getAllUserMQL();

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByUserId(String userId);
}