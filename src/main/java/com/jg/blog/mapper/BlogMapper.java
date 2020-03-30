package com.jg.blog.mapper;

import com.jg.blog.pojo.Blog;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 博客表Mapper
 * </p>
 *

 */
@Component
public interface BlogMapper {

    /**
     * 保存
     * @param blog
     */
    void save(Blog blog);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    Blog getById(String id);

    /**
     * 更新
     * @param blog
     */
    void update(Blog blog);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Blog readById(String id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(String id);
}
