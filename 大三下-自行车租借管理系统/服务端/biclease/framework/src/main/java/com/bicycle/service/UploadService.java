package com.bicycle.service;

import com.bicycle.common.R;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    /**
     * 上传图片
     * @param image
     * @return R
     */
    R uploadBicycleImg(MultipartFile image);
}