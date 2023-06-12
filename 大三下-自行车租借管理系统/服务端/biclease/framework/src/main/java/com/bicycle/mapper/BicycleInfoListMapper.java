package com.bicycle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bicycle.entity.BicycleInfoList;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("bicycleInfoListMapper")
public interface BicycleInfoListMapper extends BaseMapper<BicycleInfoList> {

    /**
     * 自行车查询
     * @return List
     */
    public List<BicycleInfoList> queryBicycleInfo();
}
