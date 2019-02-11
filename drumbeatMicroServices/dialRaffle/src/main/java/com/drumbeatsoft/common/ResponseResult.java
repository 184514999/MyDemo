package com.drumbeatsoft.common;

import java.util.List;

public class ResponseResult<T> {
    //操作代码
    int code;
    //描述信息
    String desc;
    //数据列表
    List<T> list;

    public ResponseResult() {
    }

    public ResponseResult(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public ResponseResult(int code, String desc, List<T> list) {
        this.code = code;
        this.desc = desc;
        this.list = list;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
