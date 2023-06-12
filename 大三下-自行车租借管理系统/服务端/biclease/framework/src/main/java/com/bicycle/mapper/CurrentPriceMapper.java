package com.bicycle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bicycle.entity.CurrentPrice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component("currentPriceMapper")
public interface CurrentPriceMapper extends BaseMapper<CurrentPrice> {

    /**
     * 删除区间时价
     * @param currentpriceId
     * @return int
     */
    public int delCurrentPriceInfoById(String currentpriceId);
}