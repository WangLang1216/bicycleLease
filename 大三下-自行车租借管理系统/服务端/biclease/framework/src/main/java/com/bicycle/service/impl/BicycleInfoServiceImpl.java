package com.bicycle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.bicycle.config.IDCommon;
import com.bicycle.service.BicycleInfoService;
import com.bicycle.entity.BicycleInfo;
import com.bicycle.mapper.BicycleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Bicycleinfo)表服务实现类
 *
 * @author makejava
 * @since 2023-06-02 20:19:48
 */
@Service("bicycleinfoService")
public class BicycleInfoServiceImpl extends ServiceImpl<BicycleInfoMapper, BicycleInfo> implements BicycleInfoService {

    @Autowired
    private BicycleInfoMapper bicycleInfoMapper;

    @Override
    public void addBicycleInfo(BicycleInfo bicycleInfo) {
        bicycleInfo.setBicycleinfoId(IDCommon.createBicycleinfoId(bicycleInfo.getbBrand(),bicycleInfo.getbName()));
    }

    @Override
    public int deleteBicycleInfoListById(List<String> listBicycleinfoId) {
        return bicycleInfoMapper.deleteBicycleInfoListById(listBicycleinfoId);
    }

    @Override
    public int updateBicycleInfoById(BicycleInfo bicycleInfo) {
        return bicycleInfoMapper.updateBicycleInfoById(bicycleInfo);
    }
}
