package com.jg.blog.service.impl;


import com.jg.blog.mapper.AdminMapper;
import com.jg.blog.pojo.Admin;
import com.jg.blog.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表服务实现类
 * </p>
 *
*/
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin getByUserName(String userName) {
        return adminMapper.getByUserName(userName);
    }

    /**
     * 查询用户
     * @return
     */
    @Override
    public Admin getAdmin() {
     return adminMapper.getAdmin();
    }

    /**
     * 更新个人信息
     */

    @Override
    public void updateInfo(Admin admin) {
        adminMapper.updateInfo(admin);
    }

    /**
     * 更新密码
     * @param admin
     */
    @Override
    public void updatePassWord(Admin admin) {
        Admin oldAdmin=adminMapper.getAdmin();
        oldAdmin.setPassword(admin.getPassword());
        adminMapper.updateInfo(oldAdmin);
    }

}
