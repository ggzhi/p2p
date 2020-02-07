package com.xmg.p2p.business.mapper;
import java.util.List;

import com.xmg.p2p.business.domain.BidRequest;
import com.xmg.p2p.business.query.BidRequestQueryObject;


public interface BidRequestMapper {

    int insert(BidRequest record);

    BidRequest selectByPrimaryKey(Long id);

    int updateByPrimaryKey(BidRequest record);
    
    //分页
    int queryForCount(BidRequestQueryObject qo);
    
    List<BidRequest> query(BidRequestQueryObject qo);

	

}