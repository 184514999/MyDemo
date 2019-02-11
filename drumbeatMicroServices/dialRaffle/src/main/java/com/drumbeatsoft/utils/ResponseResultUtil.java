package com.drumbeatsoft.utils;

import com.drumbeatsoft.common.ResponseResult;

import java.util.List;

public class ResponseResultUtil {
    private static ResponseResult responseResult;

    static {
        responseResult = new ResponseResult();
    }

    /**
     * 返回成功结果
     * @param list
     * @return
     */
    public static ResponseResult getSuccessResult(List list){
        responseResult.setCode(0);
        responseResult.setDesc("success");
        responseResult.setList(list);
        return responseResult;
    }


    /**
     * 返回失败结果
     * @return
     */
    public static ResponseResult getFalseResult(){
        responseResult.setCode(1);
        responseResult.setDesc("false");
        return responseResult;
    }
}
