package com.bicycle.entity;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
public class OrderDepositList {

    private String orderdepositId;

    private double oPrice;

    private int oStatus;

    private String accountcustId;

    private String cName;

    private String bBrand;

    private String bName;

    private String lDatefrist;
}
