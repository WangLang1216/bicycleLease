package com.bicycle.controller;

import com.bicycle.common.R;
import com.bicycle.entity.OrderDepositList;
import com.bicycle.service.OrderDepositService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/deposit")
public class OrderDepositController {

    @Autowired
    private OrderDepositService orderDepositService;

    /**
     * 订单押金查询
     * @return List<OrderDepositList>
     */
    @GetMapping("/queryOrderDepositList")
    public R<List<OrderDepositList>> queryOrderDepositList() {
        List<OrderDepositList> r = orderDepositService.queryOrderDepositList();
        return r.size() == 0 ? R.error("未查询到押金订单数据！") : R.success(r);
    }

    /**
     * 修改订单状态
     * @param map
     * @return Integer
     */
    @PostMapping("/updateOrderDepositList")
    public R<Integer> updateOrderDepositList(@RequestBody Map<String, Object> map) {
        int r = orderDepositService.updateOrderDepositList(map);
        return r == 0 ? R.error("修改失败！") : R.success(r);
    }
}
