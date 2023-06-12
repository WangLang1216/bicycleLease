package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.entity.Reservation;
import com.bicycle.entity.ReservationList;
import com.bicycle.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
@CrossOrigin
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    /**
     * 新增预约订单
     * @param accountcustId
     * @param bicycleinfoId
     * @return Integer
     */
    @PostMapping("/addReservation")
    public R<Integer> addReservation(@RequestBody List<String> list){
        String accountcustId = list.get(0);
        String bicycleinfoId = list.get(1);
        int r = reservationService.addReservationList(accountcustId, bicycleinfoId);
        return r == 0 ? R.error("添加失败！") : R.success(r);
    }


    /**
     * 修改预约订单信息
     * @param reservation
     * @return Integer
     */
    @PostMapping("/updateReservation")
    public R<Integer> updateReservation(@RequestBody Reservation reservation){
        int r = reservationService.updateReservation(reservation);
        return r == 0 ? R.error("修改失败！") : R.success(r);
    }


    /**
     * 根据顾客id查询订单
     * @param accountcustId
     * @return List<Reservation>
     */
    @GetMapping("/queryReservationListById/{accountcustId}")
    public R<List<ReservationList>> queryReservationListById(@PathVariable String accountcustId){
        List<ReservationList> list = reservationService.queryReservationListById(accountcustId);
        return list.size() == 0 ? R.error("未查询到订单信息！") : R.success(list);
    }


    /**
     * 根据预约订单id删除数据（多/单）
     * @param listReservationId
     * @return Integer
     */
    @PostMapping("/delReservationListById")
    public R<Integer> delReservationListById(@RequestBody List<String> listReservationId) {
        int r = reservationService.delReservationListById(listReservationId);
        return r < listReservationId.size() ? R.error("与预期删除量不匹配！") : R.success(r);
    }


    /**
     * 根据订单id结算预约订单（多/单）
     * @param mapReservationId
     * @return Integer
     */
    @PostMapping("/fulfilReservationListById")
    public R<Integer> fulfilReservationListById(@RequestBody Map<String, Object> mapReservationId) {
        int r = reservationService.fulfilReservationListById(mapReservationId);
        return r == 0 ? R.error("结算订单失败！") : R.success(r);
    }


}
