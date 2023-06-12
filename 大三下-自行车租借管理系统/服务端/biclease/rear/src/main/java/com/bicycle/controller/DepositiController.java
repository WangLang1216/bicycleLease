package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.config.IDCommon;
import com.bicycle.entity.CurrentPrice;
import com.bicycle.entity.Depositi;
import com.bicycle.service.CurrentPriceService;
import com.bicycle.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/deposit")
public class DepositiController {

    @Autowired
    private DepositService depositService;
    @Autowired
    private CurrentPriceService currentPriceService;

    /**
     * 新增押金信息
     * @param depositi
     * @return Integer
     */
    @PostMapping("/addDepositiInfo")
    public R<Integer> addDepositiInfo(@RequestBody Depositi depositi){
        depositi.setDepositId(IDCommon.createReservationId());
        boolean r = depositService.save(depositi);
        return r ? R.success(1) : R.error("新增失败！");
    }

    /**
     * 区间押金查询
     * @return List<Depositi>
     */
    @GetMapping("/queryDepositiInfoList")
    public R<List<Depositi>> queryDepositiInfoList(){
        List<Depositi> list = depositService.list();
        return list.size() == 0 ? R.error("查询失败!") : R.success(list);

    }

    /**
     * 新增时价信息
     * @param currentPrice
     * @return Integer
     */
    @PostMapping("/addCurrentPriceInfo")
    public R<Integer> addCurrentPriceInfo(@RequestBody CurrentPrice currentPrice){
        currentPrice.setCurrentpriceId(IDCommon.createReservationId());
        boolean b = currentPriceService.save(currentPrice);
        return b ? R.success(1) : R.error("新增失败！");
    }

    /**
     * 区间时价查询
     * @return List<CurrentPrice>
     */
    @GetMapping("/queryCurrentPriceInfoList")
    public R<List<CurrentPrice>> queryCurrentPriceInfoList() {
        List<CurrentPrice> list = currentPriceService.list();
        return list.size() == 0 ? R.error("查询失败!") : R.success(list);

    }

    /**
     * 删除区间时价
     * @param currentpriceId
     * @return Integer
     */
    @GetMapping("/delCurrentPriceInfoById/{currentpriceId}")
    public R<Integer> delCurrentPriceInfoById(@PathVariable String currentpriceId) {
        int r = currentPriceService.delCurrentPriceInfoById(currentpriceId);
        return r == 0 ? R.error("删除失败!") : R.success(r);
    }

    /**
     * 删除区间押金
     * @param depositId
     * @return Integer
     */
    @GetMapping("/delDepositiInfoById/{depositId}")
    public R<Integer> delDepositiInfoById(@PathVariable String depositId) {
        int r = depositService.delDepositiInfoById(depositId);
        return r == 0 ? R.error("删除失败!") : R.success(r);
    }
}