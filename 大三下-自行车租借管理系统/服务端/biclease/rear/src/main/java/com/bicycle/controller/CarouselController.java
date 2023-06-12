package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    /**
     * 删除轮播图数据
     * @param carouselId
     * @return R<Integer>
     */
    @GetMapping("/deleteCarouselInfoById/{carouselId}")
    public R<Integer> deleteCarouselInfoById(@PathVariable String carouselId){
        int r = carouselService.deleteCarouselInfoById(carouselId);
        return r == 0 ? R.error("删除失败!") : R.success(r);
    }

    /**
     * 新增轮播图数据
     * @param carouselId
     * @param bicycleInfoId
     * @return int
     */
    @GetMapping("/addCarouselInfo/{bicycleInfoId}")
    public R<Integer> addCarouselInfo(@PathVariable String bicycleInfoId){
        int r = carouselService.addCarouselInfo(bicycleInfoId);
        return r == 0 ? R.error("新增失败！") : R.success(r);
    }

    /**
     * 自定义新增轮播图片
     * @param image
     * @param imgurl
     * @return Integer
     */
    @PostMapping("/addCarouselInfoDIY")
    public R<Integer> addCarouselInfoDIY(@RequestBody Map<String, String> map) {
        String image = map.get("image");
        String imgurl = map.get("imgurl");
        int r = carouselService.addCarouselInfoDIY(image, imgurl);
        return r == 0 ? R.error("新增失败！") : R.success(r);
    }
}
