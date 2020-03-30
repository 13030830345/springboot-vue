package com.jg.blog.controller;

import com.jg.blog.mapper.TypeMapper;
import com.jg.blog.pojo.Type;
import com.jg.blog.service.TypeService;
import com.jg.blog.utils.Result;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * com.jg.blog.controller
 * 76773:cl
 * 2020/3/23
 * blog
 */

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    TypeService typeService;
    /**
     * 添加类型
     * @return
     */
    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public Result<Object> save(@RequestBody Type type){
        typeService.save(type);
        return  new Result<>("添加成功");
    }
    /**
     * 后台查询
     */
    @RequestMapping(value = "/listBack", method = RequestMethod.GET)
    public Result<List<Type>> getAll(){
        List<Type> typeList =typeService.getAll();
        return  new Result<>();
    }

    /**
     * 前台查询
     */
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result<List<Type>> getList(){
        List<Type> typeList =typeService.getTypeList();
        return  new Result<>(typeList);
    }

    /**
     * 根据id更新
     * @param type
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    public Result<Object> update(@RequestBody Type type)
    {
        typeService.update(type);
        return  new Result<>( "更新成功");
    }
    /**
     *根据id启用
     */
    @RequestMapping(value = "/enable/{id}",method = RequestMethod.PUT)
    public Result<Object> enable(@PathVariable Integer id){
        typeService.enableById(id);
        return new Result<>("已启动");
    }

    /**
     *根据id弃用
     * @param id
     * @return
     */
    @RequestMapping(value = "/disable/{id}", method = RequestMethod.PUT)
    public  Result<Object> disable(@PathVariable Integer id){
        typeService.disableById(id);
        return new Result<>("已弃用");
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result<Object> delete(@PathVariable Integer id){
        typeService.deleteById(id);
        return new Result<>("删除成功");
    }
}
