package com.bicycle.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
 
public class Utils {
    public static <T> Page<T> getPage(PageParam pageParam, QueryAction<T> queryAction){
        //在查询之前设置分页参数，再执行查询和设置分页参数之间不能有其他的查询。
        //该方法用于设置分页参数对象（含有页码pageName和每页记录数pageSize两个属性）
        PageHelper.startPage(pageParam);
        List<T> list = queryAction.executeQuery();//执行一个查询，获得List集合
        //紧挨在查询之后构造分页信息对象
        PageInfo<T> pageInfo = new PageInfo<>(list);
        Page<T> page = new Page<>();
        page.setCurrent(pageInfo.getPageNum());//当前页
        page.setFirst(1);//首页
        page.setPre(pageInfo.getPrePage());//上一页
        page.setNext(pageInfo.getNextPage());//下一页
        page.setLast(pageInfo.getPages());//最后一页
        page.setPageSize(pageInfo.getPageSize());//每页最大记录数
        page.setTotal(pageInfo.getTotal());//总记录数
        page.setPages(pageInfo.getPages());//总页数
        page.setCurrSize(pageInfo.getSize());//当前页实际记录数
        page.setList(pageInfo.getList());//当前页数据记录
        return page;
    }
}