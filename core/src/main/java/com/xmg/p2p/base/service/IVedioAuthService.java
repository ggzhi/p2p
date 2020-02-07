package com.xmg.p2p.base.service;

import com.xmg.p2p.base.query.PageResult;
import com.xmg.p2p.base.query.VedioAuthQueryObject;

/**
 * 视频认证服务
 * @author 14847
 *
 */
public interface IVedioAuthService {
	
	PageResult query(VedioAuthQueryObject qo);
	
	/**
	 * 视频审核逻辑
	 * @param loginInfoValue
	 * @param remark
	 * @param state
	 */
	void audit(Long loginInfoValue, String remark, int state);
}
