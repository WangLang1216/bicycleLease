package com.bicycle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bicycle.entity.Customer;

import java.util.List;

public interface CustomerService extends IService<Customer> {

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
