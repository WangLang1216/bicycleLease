package com.bicycle.entity;

import lombok.Data;

/**
 * 连锁店表
 */
@Data
public class Store {

    private String storeId;

    private String sName;

    private String sAddress;

    private String sPhone;

    private int sStatus;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public int getsStatus() {
        return sStatus;
    }

    public void setsStatus(int sStatus) {
        this.sStatus = sStatus;
    }
}