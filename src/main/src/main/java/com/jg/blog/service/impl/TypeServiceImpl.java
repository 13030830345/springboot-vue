package com.jg.blog.service.impl;


import com.jg.blog.enums.StatusEnums;
import com.jg.blog.exception.BlogException;

import com.jg.blog.mapper.TypeMapper;
import com.jg.blog.pojo.Type;
import com.jg.blog.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 帖子类型表服务实现类
 * </p>
 *

 */
@Service
@Slf4j
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;
    @Override
    public void save(Type type) {

        //查询名称是否存在
        Type t = typeMapper.getByName(type.getTypeName());
        //判断
        if (t!=null){
            throw new BlogException("该分类已存在");
        }
        typeMapper.insert(type);
    }

    @Override
    public List<Type> getAll() {
        return typeMapper.getAll();
    }

    @Override
    public List<Type> getTypeList() {
        return typeMapper.getTypeList();
    }

    @Override
    public void update(Type type) {
        typeMapper.update(type);
    }

    @Override
    public void enableById(Integer id) {
        //先查再启用
        Type type=typeMapper.getById(id);
        type.setEnable(StatusEnums.ENABLE.getCode());
        typeMapper.update(type);
    }

    /**
     * 根据id弃用
     * @param id
     */
    @Override
    public void disableById(Integer id) {
        //先查然后再弃用
        Type type=typeMapper.getById(id);
        type.setEnable(StatusEnums.NOT_ENABLE.getCode());
        typeMapper.update(type);
    }

    /***
     * 根据id删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        typeMapper.deleteById(id);
    }
}
