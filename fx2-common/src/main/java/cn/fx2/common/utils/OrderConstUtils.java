package cn.fx2.common.utils;

//订单常量
public enum OrderConstUtils {
    ORDER_TYPE_DOOM(1,"预定"),
    ORDER_TYPE_TAKEAWAY(2,"外卖"),
    ORDER_TYPE_INCOME(3,"店内");

    private final int order;
    private final String msg;
    OrderConstUtils(int order,String msg) {
        this.order = order;
        this.msg = msg;
    }
    public int getOrder() {
        return order;
    }

    public String getMsg() {
        return msg;
    }
}
