package com.jg.blog.service.impl;


import com.jg.blog.mapper.BlogMapper;
import com.jg.blog.mapper.TypeMapper;
import com.jg.blog.pojo.*;
import com.jg.blog.service.BlogService;
import com.jg.blog.utils.IdWorker;


import com.jg.blog.vo.BlogVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 博客表服务实现类
 * </p>
 *

 */
@Service
@Slf4j
public class BlogServiceImpl implements BlogService {
    @Autowired BlogMapper blogMapper;
    @Autowired
    TypeMapper typeMapper;
    /***
     * 保存
     * @param blog
     */
    @Override
    public void save(Blog blog) {
        blogMapper.save(blog);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Blog getById(String id) {
        return  blogMapper.getById(id);
    }

    /**
     * 更新
     * @param blog
     */
    @Override
    public void update(Blog blog) {
        blogMapper.update(blog);
    }

    /**
     * 根据id 查询 阅读数加1
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor =Exception.class )
    public BlogVo readById(String id) {
        Blog blog=blogMapper.getById(id);
        blog.setBlogRead(blog.getBlogRead()+1);
        //将blog转为blogVo
        BlogVo blogVo=new BlogVo();
        //用spring BeanUtils转换
        BeanUtils.copyProperties(blog,blogVo);
        //查询分类
        Type type=typeMapper.getById(blog.getBlogType());
        blogVo.setType(type);
        return  blogVo;
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void deleteById(String id) {
        blogMapper.deleteById(id);
    }
}
