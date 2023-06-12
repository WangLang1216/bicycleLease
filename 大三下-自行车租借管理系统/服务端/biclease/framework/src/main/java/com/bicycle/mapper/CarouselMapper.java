package com.bicycle.mapper;


import com.bicycle.entity.Carousel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component("carouselMapper")
public interface CarouselMapper {

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
     * 新增轮播图信息
     * @param bicycleInfoId
     * @param carouselId
     * @return int
     */
    public int addCarouselInfo(String carouselId, String bicycleInfoId);

    /**
     * DIY轮播图片
     * @param image
     * @param imgurl
     * @return int
     */
    public int addCarouselInfoDIY(String carouselId, String image, String imgurl);
}