package com.bicycle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bicycle.service.CustomerService;
import com.bicycle.entity.Customer;
import com.bicycle.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public Customer queryCustomerById(String custaccountId) {
        return customerMapper.queryCustomerById(custaccountId);
    }

    @Override
    public List<Customer> queryCustomerList() {
        return customerMapper.queryCustomerList();
    }
}
