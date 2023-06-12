package com.bicycle.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bicycle.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component("customerMapper")
public interface CustomerMapper extends BaseMapper<Customer> {

    /**
     * 更新用户信息
     * @param customer
     * @return int
     */
    public int updateCustomer(Customer customer);

    /**
     * 根据id查询用户信息
     * @param custaccountId
     * @return CustAccount
     */
    public Customer queryCustomerById(String custaccountId);

    /**
     * 顾客信息查询
     * @return List<Customer>
     */
    public List<Customer> queryCustomerList();
}