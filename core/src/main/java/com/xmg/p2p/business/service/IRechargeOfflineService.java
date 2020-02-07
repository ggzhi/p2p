package com.xmg.p2p.business.service;

import com.xmg.p2p.base.query.PageResult;
import com.xmg.p2p.business.domain.RechargeOffline;
import com.xmg.p2p.business.query.RechargeOfflineQueryObject;

/**
 * 线下充值服务
 * @author 14847
 *
 */
public interface IRechargeOfflineService {
	
	/**
	 * 提交线下充值单申请
	 * @param recharge
	 */
	void apply(RechargeOffline recharge);
	
	PageResult query(RechargeOfflineQueryObject qo);
	
	/**
	 * 审核
	 * @param id
	 * @param remark
	 * @param state
	 */
	void audit(Long id, String remark, int state); 

}
