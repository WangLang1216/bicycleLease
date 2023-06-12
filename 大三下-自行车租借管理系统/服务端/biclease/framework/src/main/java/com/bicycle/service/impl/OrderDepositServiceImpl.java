package com.bicycle.service.impl;

import com.bicycle.entity.OrderDepositList;
import com.bicycle.mapper.OrderDepositMapper;
import com.bicycle.service.OrderDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderDepositServiceImpl implements OrderDepositService {

    @Autowired
    private OrderDepositMapper orderDepositMapper;

    @Override
    public List<OrderDepositList> queryOrderDepositList() {
        return orderDepositMapper.queryOrderDepositList();
    }

    @Override
    public int updateOrderDepositList(Map<String, Object> map) {
        return orderDepositMapper.updateOrderDepositList(map);
    }
}
