package com.jg.blog.enums;

import lombok.Getter;

/**
 * com.jg.blog.enums
 * 76773:cl
 * 2020/3/15
 * blog
 */
@Getter
public enum  StatusEnums {
    /**
     *逻辑删除状态
     * */
    DELETED(1,"已删除"),
    NOT_DELETED(0,"未删除"),

    /**
     *启用状态
     * */
    ENABLE(0,"启用"),
    NOT_ENABLE(1,"为启用"),
    /**
     *性别：男,女
     * */
    SEX_MAN(1,"男"),
    SEX_WOMAN(2,"女"),
    /**
     *日志请求成功得提示语
     * */
    REQUEST_SUCCESS(1,"请求正常"),
    REQUEST_ERROT(0,"请求异常"),
    ADMIN(0, "管理员"),
    USER(1, "普通用户");

    ;
    Integer code;
    String msg;

    StatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }}
