package com.bicycle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bicycle.config.Page;
import com.bicycle.entity.BicycleInfoList;

import java.util.List;

/**
 * @Projectname: biclease
 * @Filename: BicycleInfoListService
 * @Author: 李燕军
 * @Data:2023/6/6 14:06
 * @Description: TODO
 */
public interface BicycleInfoListService extends IService<BicycleInfoList> {

//    /**
//     * 自行车查询
//     * @param bicycleInfoList
//     * @param pageSize
//     * @param currentPage
//     * @return List
//     */
//    Page<BicycleInfoList> queryBicycleInfo(BicycleInfoList bicycleInfoList, Integer pageSize, Integer currentPage);

    /**
     * 自行车查询
     * @return List
     */
    List<BicycleInfoList> queryBicycleInfo();
}
