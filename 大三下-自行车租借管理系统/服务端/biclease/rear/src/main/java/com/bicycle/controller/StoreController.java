package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.entity.Store;
import com.bicycle.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * 查询店铺信息
     * @return List<Store>
     */
    @GetMapping("/queryStoreInfoList")
    public R<List<Store>> queryStoreInfoList(){
        List<Store> store = storeService.queryStoreInfoList();
        return store.size() == 0 ? R.error("查询失败") : R.success(store);
    }

    /**
     * 修改店铺信息
     * @param store
     * @return R<Integer>
     */
    @PostMapping("/updataStoreInfoById")
    public R<Integer> updataStoreInfoById(@RequestBody Store store){
        int r = storeService.updataStoreInfoById(store);
        return r == 0 ?R.error("修改失败"):R.success(r);
    }

}
