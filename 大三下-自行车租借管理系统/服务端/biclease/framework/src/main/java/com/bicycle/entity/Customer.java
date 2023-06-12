package com.bicycle.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 顾客信息表
 */
@Data
public class Customer {
    private String customerId;

    private String accountcustId;

    private String cName;

    private String cSex;

    private int cAge;

    private String cCard;

    private String cPhone;

    private String cEmail;

    private String cAddress;

    public Customer() {}

    public CustAccount customers;

    public CustAccount getCustomers() {
        return customers;
    }

    public void setCustomers(CustAccount customers) {
        this.customers = customers;
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

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex;
    }

    public int getcAge() {
        return cAge;
    }

    public void setcAge(int cAge) {
        this.cAge = cAge;
    }

    public String getcCard() {
        return cCard;
    }

    public void setcCard(String cCard) {
        this.cCard = cCard;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

}