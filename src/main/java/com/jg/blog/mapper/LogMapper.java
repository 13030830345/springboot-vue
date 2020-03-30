package com.jg.blog.mapper;

import com.jg.blog.pojo.Log;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 接口访问日志表Mapper
 * </p>
 *

 *
 */
@Component
public interface LogMapper {

    /**
     * 保存
     * @param logger
     */
    void save(Log logger);

    /**
     * 分页查询
     * @param page
     * @return
     */

}
