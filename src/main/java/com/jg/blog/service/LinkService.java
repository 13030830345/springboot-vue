package com.jg.blog.service;

import com.jg.blog.pojo.Link;

import java.util.List;

/**
 * <p>
 *     友情链接服务
 * </p>
 *
 */
public interface LinkService {

    /**
     * 保存友情链接
     * @param link
     */
    void save(Link link);

    /**
     * 更新链接
     * @param link
     */
    void update(Link link);

    /**
     * 根据id查询
     * @return
     */
    Link getById(Integer id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 查询所有
     */
    List<Link> getAll();
}
