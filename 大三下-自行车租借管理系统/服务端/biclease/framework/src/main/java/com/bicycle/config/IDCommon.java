package com.bicycle.config;

import java.text.SimpleDateFormat;
import java.util.*;

public class IDCommon {
    // uuid
    public static String createUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // 顾客信息id
    public static String createCustomerId(String card) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date()) + card.substring(card.length() - 4);
    }

    // 预约信息id
    public static String createReservationId() {
        return new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
    }

    // 自行车信息id
    public static String createBicycleinfoId(String brand, String name) {
        return ChineseConvertToPinYin.toFirstChar(brand).toUpperCase() + '-' + ChineseConvertToPinYin.spaceTruncation(name);
    }

    // 租借信息id
    public static String createLeaseInfoId(String card) {
        return new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()) + card.substring(card.length() - 4);
    }

    
}
