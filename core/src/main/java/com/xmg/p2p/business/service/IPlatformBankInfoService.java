package com.xmg.p2p.business.service;

import java.util.List;

import com.xmg.p2p.base.query.PageResult;
import com.xmg.p2p.business.domain.PlatformBankInfo;
import com.xmg.p2p.business.query.PlatformBankInfoQueryObject;

public interface IPlatformBankInfoService {
	
	PageResult query(PlatformBankInfoQueryObject qo);

	void saveOrUpdate(PlatformBankInfo bankInfo);

	List<PlatformBankInfo> listAll();
}
