package com.bicycle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bicycle.entity.Depositi;


public interface DepositService extends IService<Depositi> {

    /**
     * 删除区间时价
     * @param depositId
     * @return int
     */
    public int delDepositiInfoById(String depositId);
}
