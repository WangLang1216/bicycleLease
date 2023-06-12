package com.bicycle.service;

import com.bicycle.entity.Store;

import java.util.List;

public interface StoreService {

    /**
     * 根据店铺编号查询店铺信
     * @return List<Reservation>
     */
    public List<Store> queryStoreInfoList();

    /**
     * 修改店铺信息
     * @param store
     * @return
     */
    public int updataStoreInfoById(Store store);
}
