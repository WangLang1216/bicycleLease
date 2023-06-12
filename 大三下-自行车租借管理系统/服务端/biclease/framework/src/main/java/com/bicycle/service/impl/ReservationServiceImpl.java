package com.bicycle.service.impl;

import com.bicycle.config.IDCommon;
import com.bicycle.service.ReservationService;
import com.bicycle.entity.Reservation;
import com.bicycle.entity.ReservationList;
import com.bicycle.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    @Transactional
    public int addReservationList(String accountcustId, String bicycleinfoId) {
        String reservationId = IDCommon.createReservationId();
        return reservationMapper.addReservationList(reservationId, accountcustId, bicycleinfoId);
    }

    @Override
    public int updateReservation(Reservation reservation) {
        return reservationMapper.updateReservation(reservation);
    }

    @Override
    public List<ReservationList> queryReservationListById(String accountcustId) {
        return reservationMapper.queryReservationListById(accountcustId);
    }

    @Override
    public int delReservationListById(List<String> listReservationId) {
        return reservationMapper.delReservationListById(listReservationId);
    }

    @Override
    @Transactional
    public int fulfilReservationListById(Map<String, Object> mapReservationId) {
        String orderdepositId = IDCommon.createReservationId();
        mapReservationId.put("orderdepositId", orderdepositId);
        int r = reservationMapper.fulfilReservationListById(mapReservationId);
        r += reservationMapper.addOrderdeposit(mapReservationId);
        List<String> list = (List<String>) mapReservationId.get("reservationId");
        for (int i = 0; i < list.size(); i++) {
            r += reservationMapper.addLeaseInfo(list.get(i), (String) mapReservationId.get("orderdepositId"), (String) mapReservationId.get("rResdate"));
        }
        r += reservationMapper.updateStock(mapReservationId);
        return r;
    }

    @Override
    public List<ReservationList> queryReservationList() {
        return reservationMapper.queryReservationList();
    }
}
