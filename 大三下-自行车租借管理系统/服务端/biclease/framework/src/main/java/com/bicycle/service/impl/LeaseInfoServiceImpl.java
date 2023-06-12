package com.bicycle.service.impl;

import com.bicycle.config.ChineseConvertToPinYin;
import com.bicycle.config.IDCommon;
import com.bicycle.entity.Customer;
import com.bicycle.entity.LeaseAndCustomer;
import com.bicycle.entity.LeaseInfo;
import com.bicycle.entity.LeaseInfoList;
import com.bicycle.entity.dto.RegisterAccountDto;
import com.bicycle.mapper.CustAccountMapper;
import com.bicycle.mapper.CustomerMapper;
import com.bicycle.mapper.LeaseInfoMapper;
import com.bicycle.service.LeaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class LeaseInfoServiceImpl implements LeaseInfoService {

    @Autowired
    private LeaseInfoMapper leaseInfoMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustAccountMapper custAccountMapper;

    @Override
    @Transactional
    public int addLeaseInfo(LeaseAndCustomer leaseAndCustomer) {
        int r = 0;
        Customer c = customerMapper.queryCustomerById(leaseAndCustomer.getAccountcustId());
        if (c == null) {
            RegisterAccountDto registerAccountDto = new RegisterAccountDto();
            registerAccountDto.setCustomerId(IDCommon.createCustomerId(leaseAndCustomer.getcCard()));
            registerAccountDto.setAccountcustId(leaseAndCustomer.getAccountcustId());
            registerAccountDto.setcCard(leaseAndCustomer.getcCard());
            registerAccountDto.setcEmail(leaseAndCustomer.getcEmail());
            registerAccountDto.setcDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            registerAccountDto.setcPassword(leaseAndCustomer.getcCard().substring(leaseAndCustomer.getcCard().length() - 6));
            r += custAccountMapper.registerAccount(registerAccountDto);
            r += custAccountMapper.registerAccountInfo(registerAccountDto);
            Customer customer = new Customer();
            customer.setAccountcustId(leaseAndCustomer.getAccountcustId());
            customer.setcName(leaseAndCustomer.getcName());
            customer.setcAge(leaseAndCustomer.getcAge());
            customer.setcEmail(leaseAndCustomer.getcEmail());
            customer.setcAddress(leaseAndCustomer.getcAddress());
            r += customerMapper.updateCustomer(customer);
        }
        leaseAndCustomer.setOrderdepositId(IDCommon.createReservationId());
        r += leaseInfoMapper.addOrderdeposit(leaseAndCustomer);
        leaseAndCustomer.setLeaseInfoId(IDCommon.createLeaseInfoId(leaseAndCustomer.getcCard()));
        r += leaseInfoMapper.addLeaseInfo(leaseAndCustomer);
        Map map = new HashMap<>();
        map.put("leaseInfoId", leaseAndCustomer.getBicycleinfoId());
        map.put("lNumber", leaseAndCustomer.getlNumber());
        r += leaseInfoMapper.updateStock(map);
        return r;
    }

    @Override
    public List<LeaseInfoList> queryLeaseInfoList() {
        return leaseInfoMapper.queryLeaseInfoList();
    }

    @Override
    public int updateLeaseInfoById(LeaseInfo leaseInfo) {
        Date firstDate = leaseInfo.getlDatefrist();
        Date secondDate = leaseInfo.getlDatesecond();
        LocalTime firstTime = leaseInfo.getlTimefrist();
        LocalTime  secondTime = leaseInfo.getlTimesecond();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        int d1 = Integer.parseInt(formatter.format(firstDate));
        int d2 = Integer.parseInt(formatter.format(secondDate));
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH");
        int h1 = Integer.parseInt(f.format(firstTime));
        int h2 = Integer.parseInt(f.format(secondTime));
        if (d2 - d1 > 0) {
            if (h2 - h1 > 0) leaseInfo.setlDuration(24 * (d2 - d1) + h2 - h1);
            else leaseInfo.setlDuration(24 * (d2 - d1 - 1) + 24 - h1 + h2);
        }
        else leaseInfo.setlDuration(h2 - h1);
        return leaseInfoMapper.updateLeaseInfoById(leaseInfo);
    }

    @Override
    public int editLeaseStatusListById(Map<String, Object> map) {
        return leaseInfoMapper.editLeaseStatusListById(map);
    }
}