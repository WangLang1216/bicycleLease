package com.bicycle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bicycle.entity.Depositi;
import com.bicycle.mapper.DepositiMapper;
import com.bicycle.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositServiceImpl extends ServiceImpl<DepositiMapper, Depositi> implements DepositService {

    @Autowired
    private DepositiMapper depositiMapper;

    @Override
    public int delDepositiInfoById(String depositId) {
        return depositiMapper.delDepositiInfoById(depositId);
    }
}
