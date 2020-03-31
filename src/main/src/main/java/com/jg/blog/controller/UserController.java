//package com.jg.blog.controller;
//
//import com.jg.blog.enums.ResultEnum;
//import com.jg.blog.pojo.User;
//import com.jg.blog.service.UserService;
//import com.jg.blog.utils.Page;
//import com.jg.blog.utils.Result;
//import com.jg.blog.utils.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * com.jg.blog.controller
// * 76773:cl
// * 2020/3/27
// * blog
// */
//@RestController
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    /**
//     * 添加用户姓名
//     * @param user
//     * @return
//     */
//    @RequestMapping(value="/save" ,method = RequestMethod.POST)
//    public Result<Object> save(@RequestBody User user){
//        userService.save(user);
//        return new Result<>("添加成功");
//    }
//
//    /**
//     * 更新信息
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "update",method =RequestMethod.PUT)
//    public Result<Object> update(@RequestBody User user){
//        userService.update(user);
//        return new Result<>("更新成功");
//    }
//
//    /**
//     * 修改个人信息
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "updateInfo",method = RequestMethod.PUT)
//    public Result<Object> updateInfo(@RequestBody User user){
//        userService.updateInfo(user);
//        return new Result<>("修改成功");
//    }
//    /**
//     * 根据id查询
//     */
//    @RequestMapping(value = "/get/{id}",method = RequestMethod.DELETE)
//    public Result<User> get(@PathVariable Integer id){
//        User user=userService.getById(id);
//        return new Result<>(user);
//    }
//    /**
//     * 根据Id删除
//     */
//    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
//    public Result<Object> delete(@PathVariable Integer id){
//        return new Result<>("删除成功!");
//    }
//    /**
//     * 分页查询
//     *
//     * @param page
//     * @return
//     */
//    @RequestMapping(value = "/getByPage", method = RequestMethod.POST)
//    public Result<Page<User>> getByPage(@RequestBody Page<User> page) {
//        String sortColumn = page.getSortColumn();
//        if (StringUtils.isNotBlank(sortColumn)) {
//            // 排序列不为空
//            String[] sortColumns = {"sex", "created_time", "update_time"};
//            List<String> sortList = Arrays.asList(sortColumns);
//            if (!sortList.contains(sortColumn.toLowerCase())) {
//                return new Result<>(400, "排序参数不合法！");
//            }
//        }
//        page = userService.getByPage(page);
//        return new Result<>(page);
//    }
//
//    /**
//     * 批量或则单个重置密码
//     * @param userIds
//     * @return
//     */
//    @RequestMapping(value = "resetPwd",method = RequestMethod.PUT)
//    public Result<Object> resetPwd(@RequestBody List<Integer> userIds){
//        userService.resetPwd(userIds);
//        return new Result<>("重置成功!");
//    }
//
//}
