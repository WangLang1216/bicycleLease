package com.bicycle.service.impl;

import com.bicycle.entity.Store;
import com.bicycle.mapper.StoreMapper;
import com.bicycle.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

   @Autowired
    private StoreMapper storeMapper;

    @Override
    public int updataStoreInfoById(Store store) {
        return storeMapper.updataStoreInfoById(store);
    }

    @Override
    public List<Store> queryStoreInfoList() {
        return storeMapper.queryStoreInfoList();
    }
}
