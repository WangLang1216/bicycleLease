package com.bicycle.config;

import java.util.List;
 
public class Page<T> {
    //当前页
    private Integer current;
    //首页
    private Integer first;
    //上页
    private Integer pre;
    //下页
    private Integer next;
    //尾页
    private Integer last;
 
 
    //每页最大记录数
    private Integer pageSize;
    //总记录数
    private Long total;
    //总页数
    private Integer pages;
    //当前页实际记录数
    private Integer currSize;
 
 
    //当前页数据记录
    private List<T> list;
 
    public Integer getCurrent() {
        return current;
    }
 
    public void setCurrent(Integer current) {
        this.current = current;
    }
 
    public Integer getFirst() {
        return first;
    }
 
    public void setFirst(Integer first) {
        this.first = first;
    }
 
    public Integer getPre() {
        return pre;
    }
 
    public void setPre(Integer pre) {
        this.pre = pre;
    }
 
    public Integer getNext() {
        return next;
    }
 
    public void setNext(Integer next) {
        this.next = next;
    }
 
    public Integer getLast() {
        return last;
    }
 
    public void setLast(Integer last) {
        this.last = last;
    }
 
    public Integer getPageSize() {
        return pageSize;
    }
 
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
 
    public Long getTotal() {
        return total;
    }
 
    public void setTotal(Long total) {
        this.total = total;
    }
 
    public Integer getPages() {
        return pages;
    }
 
    public void setPages(Integer pages) {
        this.pages = pages;
    }
 
    public Integer getCurrSize() {
        return currSize;
    }
 
    public void setCurrSize(Integer currSize) {
        this.currSize = currSize;
    }
 
    public List<T> getList() {
        return list;
    }
 
    public void setList(List<T> list) {
        this.list = list;
    }
 
    @Override
    public String toString() {
        return "Page{" +
                "current=" + current +
                ", first=" + first +
                ", pre=" + pre +
                ", next=" + next +
                ", last=" + last +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", pages=" + pages +
                ", currSize=" + currSize +
                ", list=" + list +
                '}';
    }
}