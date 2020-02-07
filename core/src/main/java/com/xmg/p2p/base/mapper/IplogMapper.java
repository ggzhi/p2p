package com.xmg.p2p.base.mapper;

import com.xmg.p2p.base.domain.Iplog;
import com.xmg.p2p.base.query.IplogQueryObject;

import java.util.List;

public interface IplogMapper {

    int insert(Iplog record);

    
    /**
     * 高级查询总数
     * @param qo
     * @return
     */
	int queryForCount(IplogQueryObject qo);
	
	/**
	 * 查询当前页数据
	 * @param qo
	 * @return
	 */
	List<Iplog> query(IplogQueryObject qo);

}