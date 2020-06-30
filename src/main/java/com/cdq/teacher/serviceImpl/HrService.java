package com.cdq.teacher.serviceImpl;

import com.cdq.teacher.entity.Hr;
import com.cdq.teacher.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ClassName HrService
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/6/30 0:17
 * @Version 1.0
 */
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
            return hr;
        }
}
