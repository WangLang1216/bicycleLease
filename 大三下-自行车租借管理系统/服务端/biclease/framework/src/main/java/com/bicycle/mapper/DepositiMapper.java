package com.bicycle.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bicycle.entity.Depositi;
import org.springframework.stereotype.Component;

@Component("depositiMapper")
public interface DepositiMapper extends BaseMapper<Depositi> {

    /**
     * 删除区间时价
     * @param depositId
     * @return int
     */
    public int delDepositiInfoById(String depositId);
}