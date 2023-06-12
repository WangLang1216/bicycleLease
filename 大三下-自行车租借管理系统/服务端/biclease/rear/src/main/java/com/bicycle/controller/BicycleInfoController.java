package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.config.Page;
import com.bicycle.config.Result;
import com.bicycle.entity.BicycleInfo;
import com.bicycle.entity.BicycleInfoList;
import com.bicycle.service.BicycleInfoListService;
import com.bicycle.service.BicycleInfoService;
import com.bicycle.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Projectname: biclease
 * @Filename: BicycleController
 * @Author: 李燕军
 * @Data:2023/6/6 10:07
 * @Description: TODO
 */
@RestController
@CrossOrigin
@RequestMapping("/bicycle")
public class BicycleInfoController {
    @Autowired
    private BicycleInfoService bicycleInfoService;
    @Autowired
    private BicycleInfoListService bicycleInfoListService;
    @Autowired
    private UploadService uploadService;

    /**
     * 车辆信息新增
     * @param bicycleInfo
     * @return Integer
     */
    @PostMapping("/addBicycleInfo")
    public R<Integer> addBicycleInfo(@RequestBody BicycleInfo bicycleInfo){
        bicycleInfoService.addBicycleInfo(bicycleInfo);
        boolean r =  bicycleInfoService.save(bicycleInfo);
        return r ? R.success(1) : R.error("新增失败！");
    }

    /**
     * 删除自行车信息
     * @param listBicycleinfoId
     * @return Integer
     */
    @PostMapping("/deleteBicycleInfoListById")
    public R<Integer> deleteBicycleInfoListById(@RequestBody List<String> listBicycleinfoId) {
        int r = bicycleInfoService.deleteBicycleInfoListById(listBicycleinfoId);
        return r < listBicycleinfoId.size() ? R.error("与预期删除量不匹配！") : R.success(r);
    }

    /**
     * 修改自行车信息
     * @param bicycleInfo
     * @return Integer
     */
    @PostMapping("/updateBicycleInfoById")
    public R<Integer> updateBicycleInfoById(@RequestBody BicycleInfo bicycleInfo){
        int r =  bicycleInfoService.updateBicycleInfoById(bicycleInfo);
         return r == 0 ? R.error("修改不成功！") : R.success(r);
    }

    /**
     * 上传自行车图片
     * @param image
     * @return R
     */
    @PostMapping("/uploadBicycleImg")
    public R uploadBicycleImg(@RequestBody MultipartFile image){
        return uploadService.uploadBicycleImg(image);
    }

//    /**
//     * 查询自行车信息
//     * @param bicycleInfoList
//     * @param pageSize
//     * @param currentPage
//     * @return List<BicycleInfoList>
//     */
//    @GetMapping("/queryBicycleInfo")
//    public Result<Page<BicycleInfoList>> queryBicycleInfo(BicycleInfoList bicycleInfoList, Integer pageSize, Integer currentPage){
//        Page<BicycleInfoList> page = bicycleInfoListService.queryBicycleInfo(bicycleInfoList, pageSize, currentPage);
////        List<BicycleInfoList> lists = bicycleInfoListService.queryBicycleInfo(bicycleInfoList, pageSize, currentPage);
////        return lists.size() == 0 ? R.error("查询失败！") : R.success(lists);
//        return Result.ok(page);
//    }

    /**
     * 查询自行车信息
     * @return List<BicycleInfoList>
     */
    @GetMapping("/queryBicycleInfo")
    public R<List<BicycleInfoList>> queryBicycleInfo(){
        List<BicycleInfoList> lists = bicycleInfoListService.queryBicycleInfo();
        return lists.size() == 0 ? R.error("查询失败！") : R.success(lists);
    }

}
