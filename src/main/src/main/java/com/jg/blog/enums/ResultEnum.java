package com.jg.blog.enums;

import lombok.Getter;

/**
 * com.jg.blog.enums
 * 76773:cl
 * 2020/3/15
 * blog
 */
@Getter
public enum  ResultEnum {
    SUCCESS(20000,"操作成功"),
    ERROR(40000,"操作失败"),
    DATA_NOT_FOUND(40001,"查询失败"),
    PARAMS_NULL(40002,"参数不能为空"),
    NOT_LOGIN(40003,"当前为登入")
    ;




    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;//提示错误代码
    private  String msg;//提示语
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
