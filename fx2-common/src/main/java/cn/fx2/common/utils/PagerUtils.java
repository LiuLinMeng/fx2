package cn.fx2.common.utils;

import java.io.Serializable;
import java.util.List;
//分页工具
public class PagerUtils<T> implements Serializable {

    private static final long serialVersionUID = -4124719305633970779L;
    private Integer pageNo;// 页码
    private Integer pageSize;// 一页多少条数据
    private Integer pageSum;// 一共多少页
    private List<T> list;//数据

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSum() {
        return pageSum;
    }

    public void setPageSum(Integer pageSum,Integer pageSize) {
        this.pageSum = pageSum / pageSize + (pageSum % pageSize == 0 ? 0 : 1);
    }

    public List<T> getData() {
        return list;
    }

    public void setData(List<T> data) {
        this.list = data;
    }

    @Override
    public String toString() {
        return "Pager [pageNo=" + pageNo + ", pageSize=" + pageSize + ", pageSum=" + pageSum + ", data=" + list + "]";
    }


}