package com.cdq.teacher.serviceImpl;

import com.cdq.teacher.entity.Menu;
import com.cdq.teacher.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName MenuService
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/6/30 0:42
 * @Version 1.0
 */
@Service
@Transactional
@CacheConfig(cacheNames = "menus s_cache")
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenus();
    }
}