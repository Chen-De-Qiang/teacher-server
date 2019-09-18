package com.cdq.teacher.mapper;

import com.cdq.teacher.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUser(@Param("userId") String userId);
}
