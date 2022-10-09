package com.atguigu.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnData<T> {
    private String code;
    private String msg;
    private T data;

    public ReturnData succeed() {
        return new ReturnData(Constants.CODE_200, "", null);
    }

    public ReturnData succeed(T data) {
        return new ReturnData(Constants.CODE_200, "获取结果成功", data);
    }
    public ReturnData succeed(T data,String msg) {
        return new ReturnData(Constants.CODE_200, msg, data);
    }
    public ReturnData succeed(String code,String msg) {
        return new ReturnData(code, msg,null);
    }
    public ReturnData error(String code, String msg) {
        return new ReturnData(code, msg, null);
    }
}