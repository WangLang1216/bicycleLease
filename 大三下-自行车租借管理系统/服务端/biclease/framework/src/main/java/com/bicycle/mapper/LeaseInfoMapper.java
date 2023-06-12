package com.bicycle.mapper;


import com.bicycle.entity.LeaseAndCustomer;
import com.bicycle.entity.LeaseInfo;
import com.bicycle.entity.LeaseInfoList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("leaseInfoMapper")
public interface LeaseInfoMapper {

    /**
     * 新增租借信息
     * @param leaseAndCustomer
     * @return int
     */
    public int addLeaseInfo(LeaseAndCustomer leaseAndCustomer);
    public int addOrderdeposit(LeaseAndCustomer leaseAndCustomer);
    public int updateStock(Map map);


    /**
     * 租借信息查询
     * @return List<LeaseInfoList>
     */
    public List<LeaseInfoList> queryLeaseInfoList();


    /**
     * 修改租借信息
     * @param leaseInfo
     * @return int
     */
    public int updateLeaseInfoById(LeaseInfo leaseInfo);


    /**
     * 修改订单状态
     * @param map
     * @return int
     */
    public int editLeaseStatusListById(Map<String, Object> map);
}