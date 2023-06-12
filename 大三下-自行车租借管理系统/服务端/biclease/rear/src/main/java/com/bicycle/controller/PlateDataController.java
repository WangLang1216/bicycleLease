package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.config.IDCommon;
import com.bicycle.entity.PlateDataList;
import com.bicycle.service.PlateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plate")
public class PlateDataController {
    @Autowired
    private PlateDataService plateDataService;

    /**
     * 查询板块数据
     * @return List<PlateDataList>
     */
    @GetMapping("/queryPlateDataAll")
    public R<List<PlateDataList>> queryPlateDataAll(){
        List<PlateDataList> list = plateDataService.queryPlateDataAll();
        return (list.size() == 0) ? R.error("查询失败！") : R.success(list);
    }

    /**
     * 删除板块数据
     * @param plateDataId
     * @return Integer
     */
    @PostMapping("/deletePlateDataListById")
    public R<Integer> deletePlateDataListById(@RequestBody List<String> plateDataId){
        int r = plateDataService.deletePlateDataListById(plateDataId);
        return r == 0 ? R.error("删除失败！") : R.success(r);
    }

    /**
     * 新增板块数据
     * @param bicycleId
     * @param plate
     * @return Integer
     */
    @GetMapping("/addPlateDataInfo/{bicycleId}/{plate}")
    public R<Integer> addPlateDataInfo(@PathVariable String bicycleId, @PathVariable String plate) {
        int r = plateDataService.addPlateDataInfo(bicycleId, plate);
        return r == 0 ? R.error("新增失败！") : R.success(r);
    }

}
