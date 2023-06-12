package com.bicycle.entity;

import lombok.Data;

/**
 * 区间押金表
 */
@Data
public class Depositi {

    private String depositId;

    private String dPrimary;

    private String dSecondary;

    private double dPrice;

    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public String getdPrimary() {
        return dPrimary;
    }

    public void setdPrimary(String dPrimary) {
        this.dPrimary = dPrimary;
    }

    public String getdSecondary() {
        return dSecondary;
    }

    public void setdSecondary(String dSecondary) {
        this.dSecondary = dSecondary;
    }

    public double getdPrice() {
        return dPrice;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }
}