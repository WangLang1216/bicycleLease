package com.bicycle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bicycle.common.R;
import com.bicycle.entity.BicycleInfo;
import com.bicycle.entity.BicycleInfoList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * (Bicycleinfo)表服务接口
 *
 * @author makejava
 * @since 2023-06-02 20:19:48
 */
public interface BicycleInfoService extends IService<BicycleInfo> {

    void addBicycleInfo(BicycleInfo bicycleInfo);

    int deleteBicycleInfoListById(List<String> listBicycleinfoId);

    int updateBicycleInfoById(BicycleInfo bicycleInfo);
}
