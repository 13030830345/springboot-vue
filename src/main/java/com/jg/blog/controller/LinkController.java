package com.jg.blog.controller;

/**
 * com.jg.blog.controller
 * 76773:cl
 * 2020/3/27
 * blog
 */

import com.jg.blog.pojo.Link;
import com.jg.blog.service.LinkService;
import com.jg.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 友情链接
 */
@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    LinkService linkService;

    /**
     *保存链接
     * @param link
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Object> save(@RequestBody Link link){
        linkService.save(link);
        return new Result<>("添加成功");
    }

    /**
     * 更新链接
     * @param link
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Result<Object> update(Link link){
        linkService.update(link);
        return  new Result<>("更新成功");
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Result<Link> get(@PathVariable Integer id){
        Link link =linkService.getById(id);
        return new Result<>(link);
    }

    /**
     * 删除id
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Result<Object> delete(@PathVariable Integer id){
        linkService.deleteById(id);
        return new Result<>("删除成功!");
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result<List<Link>> list(){
        List<Link> linkList=  linkService.getAll();
        return new Result<>(linkList);
    }
}
