package com.bicycle.entity;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

/**
 * 租借信息表
 */
public class LeaseInfo {
    private String leaseInfoId;

    private String bicycleinfoId;

    private String accountcustId;

    private String orderdepositId;

    private Date lDatefrist;

    private LocalTime lTimefrist;

    private Date lDatesecond;

    private LocalTime lTimesecond;

    private int lDuration;

    private double lMoney;

    private int lNumber;

    private int lStatus;


    public String getLeaseInfoId() {
        return leaseInfoId;
    }

    public void setLeaseInfoId(String leaseInfoId) {
        this.leaseInfoId = leaseInfoId;
    }

    public String getBicycleinfoId() {
        return bicycleinfoId;
    }

    public void setBicycleinfoId(String bicycleinfoId) {
        this.bicycleinfoId = bicycleinfoId;
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

    public Date getlDatefrist() {
        return lDatefrist;
    }

    public void setlDatefrist(Date lDatefrist) {
        this.lDatefrist = lDatefrist;
    }

    public LocalTime getlTimefrist() {
        return lTimefrist;
    }

    public void setlTimefrist(LocalTime lTimefrist) {
        this.lTimefrist = lTimefrist;
    }

    public Date getlDatesecond() {
        return lDatesecond;
    }

    public void setlDatesecond(Date lDatesecond) {
        this.lDatesecond = lDatesecond;
    }

    public LocalTime getlTimesecond() {
        return lTimesecond;
    }

    public void setlTimesecond(LocalTime lTimesecond) {
        this.lTimesecond = lTimesecond;
    }

    public int getlDuration() {
        return lDuration;
    }

    public void setlDuration(int lDuration) {
        this.lDuration = lDuration;
    }

    public double getlMoney() {
        return lMoney;
    }

    public void setlMoney(double lMoney) {
        this.lMoney = lMoney;
    }

    public int getlNumber() {
        return lNumber;
    }

    public void setlNumber(int lNumber) {
        this.lNumber = lNumber;
    }

    public int getlStatus() {
        return lStatus;
    }

    public void setlStatus(int lStatus) {
        this.lStatus = lStatus;
    }
}