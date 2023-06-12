package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.entity.LeaseAndCustomer;
import com.bicycle.entity.LeaseInfo;
import com.bicycle.entity.LeaseInfoList;
import com.bicycle.service.LeaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/lease")
public class LeaseInfoController {

    @Autowired
    private LeaseInfoService leaseInfoService;

    /**
     * 租借登记
     * @param leaseAndCustomer
     * @return Integer
     */
    @PostMapping("/addLeaseInfo")
    public R<Integer> addLeaseInfo(@RequestBody LeaseAndCustomer leaseAndCustomer) {
        int r = leaseInfoService.addLeaseInfo(leaseAndCustomer);
        return r == 0 ? R.error("新增失败！") : R.success(r);
    }


    /**
     * 租借信息查询
     * @return List<LeaseInfoList>
     */
    @GetMapping("queryLeaseInfoList")
    public R<List<LeaseInfoList>> queryLeaseInfoList() {
        List<LeaseInfoList> leaseInfoLists = leaseInfoService.queryLeaseInfoList();
        return leaseInfoLists.size() == 0 ? R.error("查询失败！") : R.success(leaseInfoLists);
    }


    /**
     * 修改租借信息
     * @param leaseInfo
     * @return Integer
     */
    @PostMapping("/updateLeaseInfoById")
    public R<Integer> updateLeaseInfoById(@RequestBody LeaseInfo leaseInfo) {
        int r = leaseInfoService.updateLeaseInfoById(leaseInfo);
        return r == 0 ? R.error("修改失败！") : R.success(r);
    }

    /**
     * 修改订单状态
     * @param map
     * @return Integer
     */
    @PostMapping("/editLeaseStatusListById")
    public R<Integer> editLeaseStatusListById(@RequestBody Map<String, Object> map) {
        int r = leaseInfoService.editLeaseStatusListById(map);
        return r == 0 ? R.error("修改失败！") : R.success(r);
    }
}
