package com.bicycle.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 顾客账号表
 */
@SuppressWarnings("serial")
//@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("custaccount")
public class CustAccount {
    private String accountcustId;

    private String cPassword;

    private Date cDate;

    private int cStatus;

    public String getAccountcustId() {
        return accountcustId;
    }

    public void setAccountcustId(String accountcustId) {
        this.accountcustId = accountcustId;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public int getcStatus() {
        return cStatus;
    }

    public void setcStatus(int cStatus) {
        this.cStatus = cStatus;
    }
}