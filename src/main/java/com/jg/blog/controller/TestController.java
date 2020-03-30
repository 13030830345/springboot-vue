package com.jg.blog.controller;

import com.jg.blog.exception.BlogException;
import com.jg.blog.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.jg.blog.controller
 * 76773:cl
 * 2020/3/17
 * blog
 */
@RestController("/text")
public class TestController {
    @RequestMapping(value = "/textException/{id}",method = RequestMethod.GET)
    public Result<Object> testExcoption(@PathVariable Integer id){
        if (id==1){
            return new Result<>();
        }
        else {
            throw new BlogException("发生了异常");
        }
    }

}
