package com.jg.blog.controller;

import com.jg.blog.enums.ResultEnum;
import com.jg.blog.pojo.Admin;
import com.jg.blog.service.AdminService;
import com.jg.blog.utils.Result;
import com.jg.blog.utils.ShiroUtils;
import com.jg.blog.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.net.Authenticator;
import java.util.HashMap;
import java.util.Map;

/**
 * com.jg.blog.controller
 * 76773:cl
 * 2020/3/21
 * blog
 */
@RestController

@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result<Object> login(@RequestBody Admin admin){
        //判断用户账号密码是否错误
        if (admin==null || StringUtils.isBlank(admin.getPassword())||StringUtils.isBlank(admin.getUsername())){
            return new Result<>(ResultEnum.PARAMS_NULL.getCode(),"用户名密码错误");
        }
        Subject subject= SecurityUtils.getSubject();
        AuthenticationToken token=new UsernamePasswordToken(admin.getUsername(),admin.getPassword());
        try {
            subject.login(token);
        }catch (Exception e){
            return new Result<>(ResultEnum.PARAMS_NULL.getCode(),"用户名密码错误");
        }
        //登录成功
        Serializable sessionId =subject.getSession().getId();
        Map<String ,Object> returnMap =new HashMap<>(2);
        returnMap.put("token",sessionId);
        return new Result<>(returnMap);
    }
    /**
     * 获取当前登录用户信息
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Result<Admin> getLoginInfo(){
        Admin loginAdmin= (Admin) ShiroUtils.getLoginUser();
        return new Result<>(loginAdmin);
    }

    /**
     * 查询管理员
     * @return
     */
    @RequestMapping(value = "/getAdmin",method = RequestMethod.GET)
    public Result<Admin> getAdmin(){
        Admin admin=adminService.getAdmin();
        return new Result<>(admin);
    }
    /**
     * 更新个人信息
     */
    @RequestMapping(value = "updateInfo" ,method = RequestMethod.PUT)
    public  Result<Object> updateInfo(@RequestBody Admin admin){
        adminService.updateInfo(admin);
        return new Result<>("更新成功");
    }
    @RequestMapping(value = "updatePassWord",method = RequestMethod.PUT)
    public Result<Object> updatePassWord(@RequestBody Admin admin){
        adminService.updatePassWord(admin);
        return  new Result<>("更新成功");
    }
}
