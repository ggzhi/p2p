package com.xmg.p2p.business.mapper;

import com.xmg.p2p.business.domain.SystemAccount;

public interface SystemAccountMapper {

	int insert(SystemAccount record);

	/**
	 * 返回当前活动的那个系统账户
	 * 
	 * @return
	 */
	SystemAccount selectCurrent();

	int updateByPrimaryKey(SystemAccount record);
}