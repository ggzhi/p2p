package com.xmg.p2p.base.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmg.p2p.base.domain.Iplog;
import com.xmg.p2p.base.mapper.IplogMapper;
import com.xmg.p2p.base.query.IplogQueryObject;
import com.xmg.p2p.base.query.PageResult;
import com.xmg.p2p.base.service.IIplogService;

@Service
public class IplogServiceImpl implements IIplogService {
	
	@Autowired
	private  IplogMapper iplogMapper;
	
	
	@Override
	public PageResult query(IplogQueryObject qo) {
		int count= this.iplogMapper.queryForCount(qo);
		if(count > 0){
			List<Iplog> list = this.iplogMapper.query(qo);
			return new PageResult(list, count, qo.getCurrentPage(),
					qo.getPageSize());
		}
		return PageResult.empty(qo.getPageSize());
	}

}
