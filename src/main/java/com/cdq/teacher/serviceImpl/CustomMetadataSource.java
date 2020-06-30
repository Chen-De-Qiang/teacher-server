package com.cdq.teacher.serviceImpl;

import com.cdq.teacher.entity.Menu;
import com.cdq.teacher.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName CustomMetadataSource
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/6/30 0:40
 * @Version 1.0
 */
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher() ;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ( (FilterInvocation) o) . getRequestUrl() ;
        List<Menu> allMenu = menuService. getAllMenu() ;
        for (Menu menu : allMenu) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl) && menu.getRoles().size() > 0) {
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getName();
                }
                    return SecurityConfig.createList(values);
                }
            }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes(){
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class. isAssignableFrom(clazz);
    }
}
