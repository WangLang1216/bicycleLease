package com.bicycle.entity;

import com.bicycle.config.PageParam;
import lombok.Data;

@Data
public class BicycleInfoList extends PageParam {
    private String bicycleinfoId;

    private String sAddress;

    private double dPrice;

    private double cPrice;

    private String bBrand;

    private String bName;

    private String bType;

    private int bStock;

    private String bImage;

    private String bImgurl;

    private String bEssay;

    public String getBicycleinfoId() {
        return bicycleinfoId;
    }

    public void setBicycleinfoId(String bicycleinfoId) {
        this.bicycleinfoId = bicycleinfoId;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public double getdPrice() {
        return dPrice;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public double getcPrice() {
        return cPrice;
    }

    public void setcPrice(double cPrice) {
        this.cPrice = cPrice;
    }

    public String getbBrand() {
        return bBrand;
    }

    public void setbBrand(String bBrand) {
        this.bBrand = bBrand;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }

    public int getbStock() {
        return bStock;
    }

    public void setbStock(int bStock) {
        this.bStock = bStock;
    }

    public String getbImage() {
        return bImage;
    }

    public void setbImage(String bImage) {
        this.bImage = bImage;
    }

    public String getbImgurl() {
        return bImgurl;
    }

    public void setbImgurl(String bImgurl) {
        this.bImgurl = bImgurl;
    }

    public String getbEssay() {
        return bEssay;
    }

    public void setbEssay(String bEssay) {
        this.bEssay = bEssay;
    }
}
