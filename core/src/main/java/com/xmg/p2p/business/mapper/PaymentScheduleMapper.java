package com.xmg.p2p.business.mapper;

import java.util.List;

import com.xmg.p2p.business.domain.PaymentSchedule;
import com.xmg.p2p.business.query.PaymentScheduleQueryObject;

public interface PaymentScheduleMapper {

	int insert(PaymentSchedule record);

	PaymentSchedule selectByPrimaryKey(Long id);

	int updateByPrimaryKey(PaymentSchedule record);

	int queryForCount(PaymentScheduleQueryObject qo);

	List<PaymentSchedule> query(PaymentScheduleQueryObject qo);
}