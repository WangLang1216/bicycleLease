package com.bicycle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bicycle.common.R;
import com.bicycle.entity.CustAccount;
import com.bicycle.entity.dto.RegisterAccountDto;
import org.springframework.web.bind.annotation.PathVariable;

public interface CustAccountService extends IService<CustAccount> {

    /**
     * 修改密码
     * @param email
     * @param password
     * @return int
     */
    public int resettingAccount(String email, String password);


    /**
     * 注册
     * @param registerAccountDto
     * @return
     */
    public int registerAccount(RegisterAccountDto registerAccountDto);

    /**
     * 修改用户状态
     * @param accountcustId
     * @param Status
     * @return
     */
    public int updateStatusById(String accountcustId, String status);
}
