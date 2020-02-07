package com.xmg.p2p.base.service;

import com.xmg.p2p.base.domain.Account;
import com.xmg.p2p.business.domain.Bid;

/**
 * 账户相关服务
 * @author 14847
 *
 */
public interface IAccountService {

	/**
	 * 记住，写完mapper之后立刻写service,因为这个update是支持乐观锁的
	 * @param account
	 */
	void update(Account account);

	void add(Account account);

	Account get(Long id);
	
	/**
	 * 得到当前登录用户对应的账户信息
	 * @return
	 */
	Account getCurrent();
	
	/**
	 * 满标审核拒绝退款流水
	 * @param bid
	 * @param bidAccount
	 */
	
}
