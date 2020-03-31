package com.jg.blog.service;


import com.jg.blog.pojo.Blog;
import com.jg.blog.utils.Page;
import com.jg.blog.vo.BlogVo;

/**
 * <p>
 * 博客表服务层接口
 * </p>
 *

 */
public interface BlogService {
    /**
     * 保存
     * @param blog
     */
    void save(Blog blog);

    /**
     * 根据id查询
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
     * 更具id查询
     * @param id
     * @return
     */
    BlogVo readById(String id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(String id);
    /**
     * 跟也查询
     * @param page
     * @return
     */
    Page<BlogVo> getByPage(Page<BlogVo> page);



}
