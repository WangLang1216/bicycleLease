package com.bicycle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bicycle.service.CurrentPriceService;
import com.bicycle.entity.CurrentPrice;
import com.bicycle.mapper.CurrentPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentPriceServiceImpl extends ServiceImpl<CurrentPriceMapper, CurrentPrice> implements CurrentPriceService {

    @Autowired
    private CurrentPriceMapper currentPriceMapper;

    @Override
    public int delCurrentPriceInfoById(String currentpriceId) {
        return currentPriceMapper.delCurrentPriceInfoById(currentpriceId);
    }
}
