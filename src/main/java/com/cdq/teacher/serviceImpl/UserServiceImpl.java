package com.cdq.teacher.serviceImpl;


import com.cdq.teacher.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public String getAllUser() {
        return "hello";
    }
}
