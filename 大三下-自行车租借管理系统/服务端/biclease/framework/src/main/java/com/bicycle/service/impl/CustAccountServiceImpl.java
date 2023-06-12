package com.bicycle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bicycle.config.IDCommon;
import com.bicycle.service.CustAccountService;
import com.bicycle.entity.CustAccount;
import com.bicycle.entity.dto.RegisterAccountDto;
import com.bicycle.mapper.CustAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("custaccountService")
public class CustAccountServiceImpl extends ServiceImpl<CustAccountMapper, CustAccount> implements CustAccountService {

    @Autowired
    private CustAccountMapper custAccountMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public int resettingAccount(String email, String password) {
        return custAccountMapper.resettingAccount(email, password);
    }

    @Override
    public int registerAccount(RegisterAccountDto registerAccountDto) {
        // 判断是否为空
        int r = 0;
        if (!StringUtils.hasText(registerAccountDto.getAccountcustId())){
            return r = 0;
        }
        if (!StringUtils.hasText(registerAccountDto.getcPassword())){
            return r = -1;
        }
        if (!StringUtils.hasText(registerAccountDto.getcCard())){
            return r = -2;
        }
        if (!StringUtils.hasText(registerAccountDto.getcEmail())){
            return r = -3;
        }
        // 判断是否已存在
        if (Accountcust_idExist(registerAccountDto.getAccountcustId())){
            return r = -4;
        }
        // 对密码进行加密处理
//        String encode = passwordEncoder.encode(registerAccountDto.getcPassword());
//        registerAccountDto.setcPassword(encode);
        // 生成Customer中customerId
        registerAccountDto.setCustomerId(IDCommon.createCustomerId(registerAccountDto.getcCard()));
        // 调用mapper的连表语句
        registerAccountDto.setcDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        this.baseMapper.registerAccount(registerAccountDto);
        return this.baseMapper.registerAccountInfo(registerAccountDto);
    }
    private boolean Accountcust_idExist(String accountcust_id) {
        LambdaQueryWrapper<CustAccount> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(CustAccount::getAccountcustId,accountcust_id);
        return count(queryWrapper) > 0;
    }

    @Override
    public int updateStatusById(String accountcustId, String status) {
        return custAccountMapper.updateStatusById(accountcustId, status);
    }
}
