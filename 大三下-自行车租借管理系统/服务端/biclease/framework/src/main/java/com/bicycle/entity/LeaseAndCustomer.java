package com.bicycle.entity;

import lombok.Data;

import java.util.Date;

public class LeaseAndCustomer {

    private String leaseInfoId;

    private String accountcustId;

    private String orderdepositId;

    private String cName;

    private String cSex;

    private int cAge;

    private String cCard;

    private String cEmail;

    private String cAddress;

    private String bicycleinfoId;

    private int lNumber;

    private String lDatefrist;

    private String lTimefrist;


    public String getLeaseInfoId() {
        return leaseInfoId;
    }

    public void setLeaseInfoId(String leaseInfoId) {
        this.leaseInfoId = leaseInfoId;
    }

    public String getAccountcustId() {
        return accountcustId;
    }

    public void setAccountcustId(String accountcustId) {
        this.accountcustId = accountcustId;
    }

    public String getOrderdepositId() {
        return orderdepositId;
    }

    public void setOrderdepositId(String orderdepositId) {
        this.orderdepositId = orderdepositId;
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

    public String getBicycleinfoId() {
        return bicycleinfoId;
    }

    public void setBicycleinfoId(String bicycleinfoId) {
        this.bicycleinfoId = bicycleinfoId;
    }

    public int getlNumber() {
        return lNumber;
    }

    public void setlNumber(int lNumber) {
        this.lNumber = lNumber;
    }

    public String getlDatefrist() {
        return lDatefrist;
    }

    public void setlDatefrist(String lDatefrist) {
        this.lDatefrist = lDatefrist;
    }

    public String getlTimefrist() {
        return lTimefrist;
    }

    public void setlTimefrist(String lTimefrist) {
        this.lTimefrist = lTimefrist;
    }
}
