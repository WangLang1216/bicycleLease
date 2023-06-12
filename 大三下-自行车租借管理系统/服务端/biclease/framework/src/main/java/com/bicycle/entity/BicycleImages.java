package com.bicycle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品附属图片表
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bicycleimages")
public class BicycleImages {
    @TableId
    private String bicycleimagesId;

    private String bicycleinfoId;

    private String bImage;

    private String bImgurl;
}