package com.bicycle.entity;

import lombok.Data;

/**
 * 订单押金表
 */
@Data
public class OrderDeposit {
    private String orderdepositId;

    private double oPrice;

    private int oStatus;
}