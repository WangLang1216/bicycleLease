package com.bicycle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bicycle.entity.PlateData;
import com.bicycle.entity.PlateDataList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("plateDataMapper")
public interface PlateDataMapper extends BaseMapper<PlateData> {

    /**
     * 根据板块查询数据
     * @param plate
     * @return List<PlateDataList>
     */
    public List<PlateDataList> queryBicycleByType(String plate);

    /**
     * 查询板块数据
     * return List<PlateDataList>
     */
    public List<PlateDataList> queryPlateDataAll();

    /**
     * 删除板块数据
     * @param plateDataId
     * @return int
     */
    public int deletePlateDataListById(List<String> plateDataId);

    /**
     * 新增板块信息
     * @param platedataId
     * @param bicycleId
     * @param plate
     * @return int
     */
    public int addPlateDataInfo(String platedataId, String bicycleId, String plate);
}
