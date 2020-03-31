package com.jg.blog.realm;

import com.jg.blog.enums.ResultEnum;
import com.jg.blog.exception.BlogException;
import com.jg.blog.pojo.Admin;
import com.jg.blog.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * com.jg.blog.realm
 * 76773:cl
 * 2020/3/24
 * blog
 */
public class AdminRealm extends AuthorizingRealm {
    @Autowired
    AdminService adminService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;

        String username=usernamePasswordToken.getUsername();
        Admin admin= adminService.getByUserName(username);
        if(admin==null){
            throw new BlogException(ResultEnum.ERROR.getCode(),"用户不存在");

        }
        return new SimpleAuthenticationInfo(admin,admin.getPassword(),this.getName());
    }
}
