package com.jg.blog.pojo;

import lombok.Data;



@Data
public class CommentGoods {

    private String id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 评论id
     */
    private String commentId;

}
