package com.xmg.p2p.business.mapper;


import java.util.List;

import com.xmg.p2p.business.domain.MoneyWithdraw;
import com.xmg.p2p.business.query.MoneyWithdrawQueryObject;


public interface MoneyWithdrawMapper {

	int insert(MoneyWithdraw record);

	MoneyWithdraw selectByPrimaryKey(Long id);

	int updateByPrimaryKey(MoneyWithdraw record);
	
	int queryForCount (MoneyWithdrawQueryObject qo);
	
	List<MoneyWithdraw> query(MoneyWithdrawQueryObject qo);
	
}