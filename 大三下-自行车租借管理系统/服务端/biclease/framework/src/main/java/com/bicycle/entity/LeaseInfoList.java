package com.bicycle.entity;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class LeaseInfoList {

    private String leaseinfoId;

    private String bicycleinfoId;

    private String accountcustId;

    private String depositId;

    private String lDatefrist;

    private String lTimefrist;

    private String lDatesecond;

    private String lTimesecond;

    private int lDuration;

    private double lMoney;

    private int lNumber;

    private int lStatus;

    private String cName;

    private String bBrand;

    private String bName;

    private double dPrice;

    private double cPrice;
}
