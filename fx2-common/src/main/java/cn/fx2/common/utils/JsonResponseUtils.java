package cn.fx2.common.utils;

import java.io.Serializable;
import java.util.HashMap;
//公共返回类
public class JsonResponseUtils implements Serializable {
    private static final long serialVersionUID = -1750795577425558789L;
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonResponseUtils ok(String msg) {
        return new JsonResponseUtils(msg);
    }

    public static JsonResponseUtils ok(String msg,Object data) {
        return new JsonResponseUtils(StatusCodeUtils.SUCCESS.getCode(),msg,data);
    }

    public static JsonResponseUtils ok(int code,String msg,Object data) {
        return new JsonResponseUtils(code,msg,data);
    }

    public static JsonResponseUtils ok(int code,String msg) {
        return new JsonResponseUtils(code,msg);
    }

    public static JsonResponseUtils error(String msg) {
        return new JsonResponseUtils(StatusCodeUtils.UNKNOWN_ERROR.getCode(),msg);
    }

    public static JsonResponseUtils error(String msg,Object data) {
        return new JsonResponseUtils(StatusCodeUtils.UNKNOWN_ERROR.getCode(),msg,data);
    }

    public static JsonResponseUtils error(int code,String msg) {
        return new JsonResponseUtils(code,msg);
    }

    private JsonResponseUtils(String msg) {
        this.code = StatusCodeUtils.SUCCESS.getCode();
        this.data = new HashMap<>();
        this.msg = msg;
    }

    private JsonResponseUtils(int code, String msg) {
        this.code = code;
        this.data = new HashMap<>();
        this.msg = msg;
    }

    private JsonResponseUtils(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
