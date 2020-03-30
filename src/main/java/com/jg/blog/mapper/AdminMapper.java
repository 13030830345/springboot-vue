package com.jg.blog.mapper;

import com.jg.blog.pojo.Admin;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 管理员表Mapper
 * </p>

 */
@Component
public interface AdminMapper {
    /**
     * 根据用户名查询
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
     * 更新用户信息
     * @param admin
     */
    void updateInfo(Admin admin);
}
