package com.jg.blog.service;

import com.jg.blog.pojo.Log;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * <p>
 * 接口访问日志表服务层接口
 * </p>
 *
 * @author 稽哥
 * @date 2020-02-07 14:04:12
 * @Version 1.0
 *
 */
public interface LogService {
    /**
     * 保存
     * @param logger
     */
        void save(Log logger);

}
