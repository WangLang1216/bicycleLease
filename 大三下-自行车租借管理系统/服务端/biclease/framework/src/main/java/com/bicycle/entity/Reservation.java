package com.bicycle.entity;

import lombok.Data;

import java.util.Date;

/**
 * 预约信息表
 */
//@Data
public class Reservation {
    private String reservationId;

    private String accountcustId;

    private String bicycleinfoId;

    private Date rResdate;

    private int rNumber;

    private Double rTotalprice;

    private int rStatus;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getAccountcustId() {
        return accountcustId;
    }

    public void setAccountcustId(String accountcustId) {
        this.accountcustId = accountcustId;
    }

    public String getBicycleinfoId() {
        return bicycleinfoId;
    }

    public void setBicycleinfoId(String bicycleinfoId) {
        this.bicycleinfoId = bicycleinfoId;
    }

    public Date getrResdate() {
        return rResdate;
    }

    public void setrResdate(Date rResdate) {
        this.rResdate = rResdate;
    }

    public int getrNumber() {
        return rNumber;
    }

    public void setrNumber(int rNumber) {
        this.rNumber = rNumber;
    }

    public Double getrTotalprice() {
        return rTotalprice;
    }

    public void setrTotalprice(Double rTotalprice) {
        this.rTotalprice = rTotalprice;
    }

    public int getrStatus() {
        return rStatus;
    }

    public void setrStatus(int rStatus) {
        this.rStatus = rStatus;
    }
}