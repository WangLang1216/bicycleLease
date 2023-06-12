package com.bicycle.service;


import com.bicycle.common.R;
import com.bicycle.entity.Carousel;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CarouselService {

    /**
     * 查询前端轮播图数据
     * @return List<Carousel>
     */
    public List<Carousel> queryCarousel();

    /**
     * 删除轮播图信息
     * @param carouselId
     * @return int
     */
    public int deleteCarouselInfoById(String carouselId);

    /**
     * 新增轮播图数据
     * @param bicycleInfoId
     * @return
     */
    public int addCarouselInfo(String bicycleInfoId);

    /**
     * DIY轮播图片
     * @param image
     * @param imgurl
     * @return int
     */
    public int addCarouselInfoDIY(String image, String imgurl);
}
