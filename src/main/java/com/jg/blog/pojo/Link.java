package com.jg.blog.pojo;

import lombok.Data;


@Data
public class Link {

    private Integer linkId;
    private String linkName;
    private String linkUrl;
    private String createdTime;
    private String updateTime;
    private Integer version;
    private Integer deleted;

}
