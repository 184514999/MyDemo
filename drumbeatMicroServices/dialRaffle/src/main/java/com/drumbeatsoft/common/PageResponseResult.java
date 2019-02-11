package com.drumbeatsoft.common;

import java.util.List;

public class PageResponseResult extends ResponseResult {
    long total;   //查询到的总数据条数


    public PageResponseResult(int code, String desc, long total) {
        super(code, desc);
        this.total = total;
    }

    public PageResponseResult(int code, String desc, List list, long total) {
        super(code, desc, list);
        this.total = total;
    }

    public long getTotal() {
        return total;
    }
}
