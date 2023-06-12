package com.bicycle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bicycle.entity.CurrentPrice;
import org.springframework.web.bind.annotation.PathVariable;

public interface CurrentPriceService extends IService<CurrentPrice> {

    /**
     * 删除区间时价
     * @param currentpriceId
     * @return int
     */
    public int delCurrentPriceInfoById(String currentpriceId);
}
