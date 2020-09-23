package cn.fx2.common.utils;
//通用返回状态码
public enum StatusCodeUtils {
    SUCCESS(200,"成功"),
    FAIL(10001,"失败"),
    SAVE_FAIL(10002,"存储失败"),
    PARAMS_NULL(10003,"参数为空"),
    EDIT_FAIL(10004,"编辑失败"),
    DELETE_FAIL(10005,"删除失败"),
    SELECT_FAIL(10006,"查询失败"),
    REQUEST_PARAMETER_EXCEPTION(10007,"请求参数异常"),
    TOKEN_VERIFY_FAIL(10008,"token验证失败"),
    SIGN_VERIFY_FAIL(10009,"签名验证失败");

    private final int code;
    private final String msg;

    StatusCodeUtils(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
