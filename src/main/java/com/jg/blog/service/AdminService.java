package com.jg.blog.service;

import com.jg.blog.pojo.Admin;

/***
 * 管理员服务接口
 */
public interface AdminService {

    /***
     * 根据用户查询
     * @param userName
     * @return
     */
    Admin getByUserName(String userName);

    /**
     * 查询用户
     * @return
     */
    Admin getAdmin();

    /**
     * 更新个人信息
     */
    void updateInfo(Admin admin);

    /**
     * 更新密码
     * @param admin
     */
    void updatePassWord(Admin admin);
}
