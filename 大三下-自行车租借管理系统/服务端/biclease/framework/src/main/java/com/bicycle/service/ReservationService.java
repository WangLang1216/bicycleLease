package com.bicycle.service;

import com.bicycle.entity.Reservation;
import com.bicycle.entity.ReservationList;

import java.util.List;
import java.util.Map;

public interface ReservationService {

    /**
     * 新增预约订单
     * @param accountcustId
     * @param bicycleinfoId
     * @return int
     */
    public int addReservationList(String accountcustId, String bicycleinfoId);

    /**
     * 修改预约订单信息
     * @param reservation
     * @return int
     */
    public int updateReservation(Reservation reservation);

    /**
     * 根据顾客id查询预约订单
     * @param accountcustId
     * @return List<Reservation>
     */
    public List<ReservationList> queryReservationListById(String accountcustId);

    /**
     * 根据预约订单id删除数据（多/单）
     * @param listReservationId
     * @return int
     */
    public int delReservationListById(List<String> listReservationId);

    /**
     * 根据订单id结算预约订单（多/单）
     * @param mapReservationId
     * @return int
     */
    public int fulfilReservationListById(Map<String, Object> mapReservationId);

    /**
     * 预约订单查询
     * @return List
     */
    public List<ReservationList> queryReservationList();
}
