package com.bicycle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 时价表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("currentPrice")
public class CurrentPrice {
    @TableId
    private String currentpriceId;

    private String cPrimary;

    private String cSecondary;

    private double cPrice;

    public String getCurrentpriceId() {
        return currentpriceId;
    }

    public void setCurrentpriceId(String currentpriceId) {
        this.currentpriceId = currentpriceId;
    }

    public String getcPrimary() {
        return cPrimary;
    }

    public void setcPrimary(String cPrimary) {
        this.cPrimary = cPrimary;
    }

    public String getcSecondary() {
        return cSecondary;
    }

    public void setcSecondary(String cSecondary) {
        this.cSecondary = cSecondary;
    }

    public double getcPrice() {
        return cPrice;
    }

    public void setcPrice(double cPrice) {
        this.cPrice = cPrice;
    }
}