package com.bicycle.config;

import java.util.List;
/*
* 表示抽象的查询的行为，该查询将获得一个List集合
* */
 
public interface QueryAction<T> {
    public List<T> executeQuery();
}