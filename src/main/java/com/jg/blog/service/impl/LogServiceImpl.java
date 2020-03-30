package com.jg.blog.service.impl;


import com.jg.blog.mapper.LogMapper;
import com.jg.blog.pojo.Log;
import com.jg.blog.service.LogService;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.LogManager;

/**
 * <p>
 * 接口访问日志表服务实现类
 * </p>
 *

 *
 */
@Service
@Slf4j
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 保存
     * @param logger
     */
    @Override
    public void save(Log logger) {
        logMapper.save(logger);
    }


}
