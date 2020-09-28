package cn.fx2.common.utils.code;

public enum  AdminCodeUtils {
    PASSWORD_ERROR(10012,"密码错误");
    private final int adminCode;
    private final String adminMsg;
    AdminCodeUtils(int adminCode,String adminMsg) {
        this.adminCode = adminCode;
        this.adminMsg = adminMsg;
    }
    public int getAdminCode() {
        return adminCode;
    }
    public String getAdminMsg() {
        return adminMsg;
    }
}
