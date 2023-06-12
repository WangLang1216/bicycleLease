package com.bicycle.service;

import com.bicycle.entity.OrderDepositList;

import java.util.List;
import java.util.Map;


public interface OrderDepositService {

    /**
     * 押金订单查询
     * @return List<OrderDepositList>
     */
    public List<OrderDepositList> queryOrderDepositList();

    /**
     * 修改订单状态
     * @param map
     * @return int
     */
    public int updateOrderDepositList(Map<String, Object> map);
}
