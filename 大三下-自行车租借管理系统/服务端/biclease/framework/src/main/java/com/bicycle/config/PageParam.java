package com.bicycle.config;

public class PageParam {
    //请求页码
    private Integer pageNum = 1;
    //每页最大记录数
    private Integer pageSize = 10;
 
    public Integer getPageNum() {
        return pageNum;
    }
 
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
 
    public Integer getPageSize() {
        return pageSize;
    }
 
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}