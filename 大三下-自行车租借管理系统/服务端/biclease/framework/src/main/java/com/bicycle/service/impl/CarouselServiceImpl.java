package com.bicycle.service.impl;


import com.bicycle.config.IDCommon;
import com.bicycle.service.CarouselService;
import com.bicycle.entity.Carousel;
import com.bicycle.mapper.CarouselMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryCarousel() {
        return carouselMapper.queryCarousel();
    }

    /**
     * 删除轮播图信息
     * @param carouselId
     * @return
     */
    @Override
    public int deleteCarouselInfoById(String carouselId) {
        return carouselMapper.deleteCarouselInfoById(carouselId);
    }

    /**
     * 新增轮播图信息
     * @param bicycleInfoId
     * @return
     */
    @Override
    public int addCarouselInfo(String bicycleInfoId) {
        String carouselId = IDCommon.createReservationId();
        return carouselMapper.addCarouselInfo(carouselId, bicycleInfoId);
    }

    @Override
    public int addCarouselInfoDIY(String image, String imgurl) {
        String carouselId = IDCommon.createReservationId();
        return carouselMapper.addCarouselInfoDIY(carouselId, image, imgurl);
    }
}
