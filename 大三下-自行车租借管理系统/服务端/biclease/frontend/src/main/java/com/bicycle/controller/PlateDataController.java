package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.entity.PlateDataList;
import com.bicycle.service.PlateDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * (Platedata)表控制层
 *
 * @author makejava
 * @since 2023-06-02 20:00:59
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/product")
public class PlateDataController {
    /**
     * 服务对象
     */
    @Autowired
    private PlateDataService platedataService;


    /**
     * 根据板块查询数据
     * @param plate
     * @return
     */
    @GetMapping("/queryBicycleByType/{plate}")
    public R<List<PlateDataList>> queryBicycleByType(@PathVariable String plate) {
        List<PlateDataList> list = platedataService.queryBicycleByType(plate);
        return list.size() == 0 ? R.error("获取数据失败！") : R.success(list);
    }
}
