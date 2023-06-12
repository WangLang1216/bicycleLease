package com.bicycle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自行车信息表
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bicycleinfo")
public class BicycleInfo {
    @TableId
    private String bicycleinfoId;

    private String storeId;

    private String depositId;

    private String currentpriceId;

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

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public String getCurrentpriceId() {
        return currentpriceId;
    }

    public void setCurrentpriceId(String currentpriceId) {
        this.currentpriceId = currentpriceId;
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