package com.bicycle.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bicycle.config.Page;
import com.bicycle.config.Utils;
import com.bicycle.entity.BicycleInfoList;
import com.bicycle.mapper.BicycleInfoListMapper;
import com.bicycle.service.BicycleInfoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Projectname: biclease
 * @Filename: BicycleInfoListServiceImpl
 * @Author: 李燕军
 * @Data:2023/6/6 14:07
 * @Description: TODO
 */
@Service
public class BicycleInfoListServiceImpl extends ServiceImpl<BicycleInfoListMapper, BicycleInfoList> implements BicycleInfoListService {
    @Autowired
    private BicycleInfoListMapper bicycleInfoListMapper;


//    @Override
//    public Page<BicycleInfoList> queryBicycleInfo(BicycleInfoList bicycleInfoList, Integer pageSize, Integer currentPage) {
////        List<BicycleInfoList>  list =  bicycleInfoListMapper.queryBicycleInfo();
//
////        LambdaQueryWrapper<BicycleInfoList> queryWrapper = new LambdaQueryWrapper<>();
////        queryWrapper.eq(StringUtils.hasText(bicycleInfoList.getbName()),BicycleInfoList::getbName,bicycleInfoList.getbName());
////        queryWrapper.eq(StringUtils.hasText(bicycleInfoList.getbBrand()),BicycleInfoList::getbBrand,bicycleInfoList.getbBrand());
////        Page<BicycleInfoList> page = new Page<>(pageSize, currentPage);
////        page.setCurrent(currentPage);
////        page.setSize(pageSize);
////        page(page, queryWrapper);
////        page.getTotal();
////        page.getRecords();
//        return Utils.getPage(bicycleInfoList, () -> bicycleInfoListMapper.queryBicycleInfo());
//    }


    @Override
    public List<BicycleInfoList> queryBicycleInfo() {
        return bicycleInfoListMapper.queryBicycleInfo();
    }
}
