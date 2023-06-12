package com.bicycle.entity.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class RegisterAccountDto {
    @TableId
    private String accountcustId;
    private String cPassword;
    private String cCard;
    private String cEmail;
    private String customerId;
    @TableField(fill = FieldFill.INSERT)
    private String cDate;

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

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

    public String getcCard() {
        return cCard;
    }

    public void setcCard(String cCard) {
        this.cCard = cCard;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }
}