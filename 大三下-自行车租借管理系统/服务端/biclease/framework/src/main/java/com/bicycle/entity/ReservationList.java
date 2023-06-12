package com.bicycle.entity;

import lombok.Data;

import java.util.Date;

/**
 * 预约订单表（组合）
 */
@Data
public class ReservationList {

    private String bicycleinfoId;

    private String reservationId;

    private int rNumber;

    private double rTotalprice;

    private String bImgurl;

    private String bBrand;

    private String bName;

    private int bStock;

    private String sAddress;

    // 后台预约查询额外需要字段
    private String rResdate;

    private String accountcustId;

    private String cName;

    private int rStatus;
}
