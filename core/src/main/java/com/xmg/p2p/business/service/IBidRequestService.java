package com.xmg.p2p.business.service;

import java.math.BigDecimal;

import java.util.List;
import com.xmg.p2p.base.query.PageResult;
import com.xmg.p2p.business.domain.BidRequest;
import com.xmg.p2p.business.domain.BidRequestAuditHistory;
import com.xmg.p2p.business.query.BidRequestQueryObject;
import com.xmg.p2p.business.query.PaymentScheduleQueryObject;

/**
 * 借款相关
 * @author 14847
 *
 */
public interface IBidRequestService {

	void update(BidRequest bidRequest);

	BidRequest get(Long id);

	/**
	 * 判断用户是否具有申请借款的权利
	 * 
	 * @return
	 */
	boolean canApplyBidRequeset(Long logininfoId);

	/**
	 * 申请借款
	 * 
	 * @param bidRequest
	 */
	void apply(BidRequest bidRequest);

	/**
	 * 根据一个标查询该标的审核历史
	 * 
	 * @param id
	 * @return
	 */
	List<BidRequestAuditHistory> listAuditHistoryByBidRequest(Long id);

	PageResult query(BidRequestQueryObject qo);

	/**
	 * 发标前审核
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 */
	void publishAudit(Long id, String remark, int state);

	/**
	 * 查询首页借款列表
	 * 
	 * @return
	 */
	List<BidRequest> listIndex(int size);

	/**
	 * 投标
	 * 
	 * @param bidRequestId
	 * @param amount
	 */
	void bid(Long bidRequestId, BigDecimal amount);

	/**
	 * 满标一审
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 */
	void fullAudit1(Long id, String remark, int state);

	/**
	 * 满标二审
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 */
	void fullAudit2(Long id, String remark, int state);

	PageResult queryPaymentSchedule(PaymentScheduleQueryObject qo);

	/**
	 * 借款人还钱
	 * 
	 * @param id
	 */
	void doReturnMoney(Long id);
}