package com.xmg.p2p.business.mapper;

import com.xmg.p2p.business.domain.PlatformBankInfo;
import com.xmg.p2p.business.query.PlatformBankInfoQueryObject;

import java.util.List;

public interface PlatformBankInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformBankInfo record);

    PlatformBankInfo selectByPrimaryKey(Long id);

    List<PlatformBankInfo> selectAll();

    int updateByPrimaryKey(PlatformBankInfo record);
    
    List<PlatformBankInfo> query(PlatformBankInfoQueryObject qo);

	int queryForCount(PlatformBankInfoQueryObject qo);
}