package com.bicycle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bicycle.entity.BicycleInfo;
import com.bicycle.entity.BicycleInfoList;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Bicycleinfo)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-02 20:19:48
 */
@Component("bicycleInfoMapper")
public interface BicycleInfoMapper extends BaseMapper<BicycleInfo> {
    /**
     * 删除自行车信息
     * @param listBicycleinfoId
     * @return int
     */
    int deleteBicycleInfoListById(List<String> listBicycleinfoId);

    /**
     * 修改自行车信息
     * @param bicycleInfo
     * @return int
     */
    int updateBicycleInfoById(BicycleInfo bicycleInfo);
}
