package com.jg.blog.pojo;

import lombok.Data;


@Data
public class BlogGoods {


    private String id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 博客id
     */
    private String blogId;

}
