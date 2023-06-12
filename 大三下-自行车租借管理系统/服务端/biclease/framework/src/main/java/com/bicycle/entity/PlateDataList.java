package com.bicycle.entity;

import lombok.Data;

@Data
public class PlateDataList {
    private String bicycleinfoId;
    private String bBrand;
    private String bName;
    private String bImgurl;
    private int bStock;
    private String bEssay;
    private double cPrice;
    private String sAddress;

    // 后台额外需要字段：
    private String bType;

    private String platedataId;

    private String pPlate;
}
