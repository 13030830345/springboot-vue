package com.jg.blog.pojo;

import lombok.Data;


import java.io.Serializable;


@Data
public class BlogCollection implements Serializable {

    private static final long serialVersionUID = -535915810554536111L;

    /**
     * 收藏id
     */

    private String collectionId;

    /**
     * 帖子id
     */
    private String blogId;

    private Blog blog;

    /**
     * 用户id
     */
    private Integer userId;

    private User user;

    /**
     * 收藏时间
     */
    private String collectionTime;

}
