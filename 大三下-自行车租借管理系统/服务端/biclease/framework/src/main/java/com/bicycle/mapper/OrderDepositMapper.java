package com.bicycle.mapper;


import com.bicycle.entity.OrderDepositList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("orderDepositMapper")
public interface OrderDepositMapper {

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