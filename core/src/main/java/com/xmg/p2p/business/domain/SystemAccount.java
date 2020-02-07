package com.xmg.p2p.business.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import com.xmg.p2p.base.domain.BaseDomain;
import com.xmg.p2p.base.util.BidConst;

/**
 * 平台账户
 * 
 * @author Administrator
 * 
 */
@Setter
@Getter
public class SystemAccount extends BaseDomain {
	private int version;// 版本
	private BigDecimal usableAmount = BidConst.ZERO;// 平台账户剩余金额
	private BigDecimal freezedAmount = BidConst.ZERO;// 平台账户冻结金额
}
