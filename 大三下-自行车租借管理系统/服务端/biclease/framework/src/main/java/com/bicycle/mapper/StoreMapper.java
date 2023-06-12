package com.bicycle.mapper;

import com.bicycle.entity.Store;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("storeMapper")
public interface StoreMapper {

    /**
     * 查询店铺信息
     * @return List<Store>
     */
    public List<Store> queryStoreInfoList();

    /**
     * 修改店铺信息
     * @param store
     * @return int
     */
    public int updataStoreInfoById(Store store);
}