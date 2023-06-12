package com.bicycle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前端板块数据表
 */
//@Data
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@TableName("platedata")
public class PlateData {
    private String platedataId;

    private String bicycleinfoId;

    @TableId
    private String pPlate;

    public String getPlatedataId() {
        return platedataId;
    }

    public void setPlatedataId(String platedataId) {
        this.platedataId = platedataId;
    }

    public String getBicycleinfoId() {
        return bicycleinfoId;
    }

    public void setBicycleinfoId(String bicycleinfoId) {
        this.bicycleinfoId = bicycleinfoId;
    }

    public String getpPlate() {
        return pPlate;
    }

    public void setpPlate(String pPlate) {
        this.pPlate = pPlate;
    }
}