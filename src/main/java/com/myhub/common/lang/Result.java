package com.myhub.common.lang;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 封装的结果类
 * @author: zeng
 * @modified By:
 */
@Data
public class Result implements Serializable {
    private int code;//是否成功，200：成功。非200：异常
    private String msg;//结果消息
    private Object data;//结果数据

    /**
     * 返回成功的结果信息
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static Result succ(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    /**
     * 重载是因为，succ方法下，code和msg不重要，可以固定
     * @param data
     * @return
     */
    public static Result succ(Object data){
        return succ(200,"操作成功", data);
    }

    /**
     * 返回异常时的结果
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static Result fail(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    /**
     * 固定fail的code为400
     * @param msg
     * @param data
     * @return
     */
    public static Result fail(String msg, Object data){
        return fail(400, msg, data);
    }

    /**
     * 此类重载是因为，异常时最重要的是异常信息，而异常的数据通常不可用
     * 例如登录时未登录成功
     * @param msg
     * @return
     */
    public static Result fail(String msg){
        return fail(400, msg, null);
    }
}
