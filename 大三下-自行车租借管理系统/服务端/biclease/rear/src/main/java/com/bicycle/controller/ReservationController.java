package com.bicycle.controller;


import com.bicycle.common.R;
import com.bicycle.entity.ReservationList;
import com.bicycle.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    /**
     * 预约订单查询
     * @return List<ReservationList>
     */
    @GetMapping("/queryReservationList")
    public R<List<ReservationList>> queryReservationList(){
        List<ReservationList> r = reservationService.queryReservationList();
        return r.size() == 0 ? R.error("未查询到预约数据！") : R.success(r);
    }


}
