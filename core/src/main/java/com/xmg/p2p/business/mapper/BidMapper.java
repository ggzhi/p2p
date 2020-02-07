package com.xmg.p2p.business.mapper;

import com.xmg.p2p.business.domain.Bid;
import java.util.List;

public interface BidMapper {

    int insert(Bid record);

    Bid selectByPrimaryKey(Long id);

    List<Bid> selectAll();

}