package com.bicycle.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bicycle.common.R;
import com.bicycle.entity.BicycleImages;
import com.bicycle.service.BicycleImagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Bicycleimages)表控制层
 *
 * @author makejava
 * @since 2023-06-02 19:45:39
 */
@RestController
@CrossOrigin
@RequestMapping("/product")
@Slf4j
public class BicycleImagesController {
    /**
     * 服务对象
     */
    @Autowired
    private BicycleImagesService bicycleImagesService;

    /**
     * 根据自行车id查询附属图片
     * @param bicycleinfo_id
     * @return List<BicycleImages>
     */
    @GetMapping("/queryBicycleImages/{bicycleinfoId}")
    public R<List<BicycleImages>> queryBicycleImages(@PathVariable String bicycleinfoId){
        log.info("id:{}", bicycleinfoId);
        QueryWrapper<BicycleImages> qw = new QueryWrapper<>();
        qw.eq("bicycleinfo_id", bicycleinfoId);
        List<BicycleImages> list = bicycleImagesService.list(qw);
        if (list.size() == 0) return R.error("数据查询失败,待更新...");
        return R.success(list);
    }
}
