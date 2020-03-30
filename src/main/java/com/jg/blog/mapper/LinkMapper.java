package com.jg.blog.mapper;

import com.jg.blog.pojo.Link;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 评论表Mapper
 * </p>
 *
 */
@Component
public interface LinkMapper {
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
     * @param id
     * @return
     */
    Link getById(Integer id);

    /**
     * 根据id删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Link> getAll();

    void insert(Link link);
}
