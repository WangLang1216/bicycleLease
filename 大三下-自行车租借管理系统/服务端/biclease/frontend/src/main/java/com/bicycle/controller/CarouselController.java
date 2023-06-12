package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.entity.Carousel;
import com.bicycle.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("product")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    /**
     * 查询前端轮播图数据
     * @return List<Carousel>
     */
    @GetMapping("/queryCarousel")
    public R<List<Carousel>> queryCarousel(){
        List<Carousel> carousels =  carouselService.queryCarousel();
        return carousels.size() == 0 ? R.error("未查询到轮播图数据！") : R.success(carousels);
    }
}
