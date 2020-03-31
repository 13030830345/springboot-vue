package com.jg.blog.controller;

import afu.org.checkerframework.checker.oigj.qual.O;
import com.jg.blog.enums.ResultEnum;
import com.jg.blog.pojo.Blog;
import com.jg.blog.pojo.Type;
import com.jg.blog.service.BlogService;
import com.jg.blog.utils.IdWorker;
import com.jg.blog.utils.Page;
import com.jg.blog.utils.Result;
import com.jg.blog.utils.StringUtils;
import com.jg.blog.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * com.jg.blog.controller
 * 76773:cl
 * 2020/3/29
 * blog
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    /**
     * 保存
     */
    @Autowired
    BlogService blogService;
    @Autowired
    IdWorker idWorker;
    @RequestMapping ( value = "/save",method = RequestMethod.POST)
    public Result<Object> save(@RequestBody Blog blog){
        blog.setBlogId(idWorker.nextId()+"");
        blogService.save(blog);
        return new Result<>("保存成功");
    }
    /**
     * 根据id查询
     */
    @RequestMapping(value = "/get/{id}",method = RequestMethod.PUT)
    public Result<Blog> getById(@PathVariable String id){
        Blog blog=blogService.getById(id);
        return new Result<>(blog);
    }

    /**
     * 更新
     * @param blog
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Result<Blog> update(@RequestBody Blog blog){
        blogService.update(blog);
        return new Result<>("更新成功");
    }

    /**
     * 阅读量
     * @param id
     * @return
     */
   @RequestMapping(value="/read/{id}",method = RequestMethod.GET)
    public Result<BlogVo> read(@PathVariable String id){
       BlogVo blog=blogService.readById(id);
        return new Result<>(blog);
   }
    /**
     * 删除文章
     * @param id
     * @return
     */
   @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result<Object> delete(@PathVariable String id){
       blogService.deleteById(id);
       return new Result<>("删除成功");
   }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @RequestMapping(value = "/getByPage", method = RequestMethod.POST)
    public Result<Page<BlogVo>> getByPage(@RequestBody Page<BlogVo> page) {
        String sortColumn=page.getSortColumn();
        if (StringUtils.isNotBlank(sortColumn)) {
            // 排序列不为空
            String[] sortColumns = {"blog_goods", "blog_read", "blog_collection",
                    "type_name", "blog_comment", "created_time", "update_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
                return new Result<>(ResultEnum.PARAMS_ERROR.getCode(), "排序参数不合法！");
            }
        }
        page = blogService.getByPage(page);
        return new Result<>(page);
    }

}
