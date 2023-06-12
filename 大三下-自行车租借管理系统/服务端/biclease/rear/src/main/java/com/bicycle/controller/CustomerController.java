package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.entity.Customer;
import com.bicycle.service.CustAccountService;
import com.bicycle.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustAccountService custAccountService;

    /**
     * 顾客信息查询
     * @return List<Customer>
     */
    @GetMapping("/queryCustomerList")
    public R<List<Customer>> queryCustomerList(){
        List<Customer> r= customerService.queryCustomerList();
        return r.size() == 0 ? R.error("未查询到预约订单数据！") : R.success(r);
    }

    /**
     * 修改用户状态
     * @param accountcustId
     * @param status
     * @return Integer
     */
    @GetMapping("/updateStatusById/{accountcustId}/{status}")
    public R<Integer> updateStatusById(@PathVariable String accountcustId, @PathVariable String status) {
        int r = custAccountService.updateStatusById(accountcustId, status);
        return r == 0 ? R.error("修改失败！") : R.success(r);
    }

}
