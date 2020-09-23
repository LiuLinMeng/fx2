package cn.fx2.common.utils;
//状态常量
public enum StatusConstUtils {
    STATUS_NORMAL(1,"正常"),
    STATUS_PENDING(2,"待审核"),
    STATUS_DELETE(3,"已删除");
    private final int status;
    private final String statusMessage;
    StatusConstUtils(int status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
    }
    public int getStatus() {
        return status;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
}
