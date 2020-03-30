package com.jg.blog.service.impl;

import com.jg.blog.exception.BlogException;
import com.jg.blog.mapper.LinkMapper;
import com.jg.blog.pojo.Link;
import com.jg.blog.service.LinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * </p>
 *

 *
 */
@Service
@Slf4j
public class LinkServiceImpl implements LinkService {
    /**
     * 保存链接
     */
    @Autowired
    LinkMapper linkMapper;
    @Override
    public void save(Link link) {
        linkMapper.insert(link);

    }

    /**
     * 更新链接
     * @param link
     */
    @Override
    public void update(Link link) {
        linkMapper.update(link);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Link getById(Integer id) {
        Link link=linkMapper.getById(id);
        return link;
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        Link link=linkMapper.getById(id);
        if (link!=null ){
            linkMapper.delete(id);
        }
        else {
            throw new BlogException("当前链接不存在");
        }
    }

    @Override
    public List<Link> getAll() {
        List<Link> linkList=linkMapper.getAll();
        return linkList;
    }
}
