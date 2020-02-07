package com.xmg.p2p.business.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.xmg.p2p.base.domain.BaseDomain;

/**
 * 系统账户账户流水
 * 
 * @author Administrator
 * 
 */
@Getter
@Setter
public class SystemAccountFlow extends BaseDomain {

	private Date createdDate;// 流水创建时间
	private int accountActionType;// 系统账户流水类型
	private BigDecimal amount;// 流水相关金额
	private String note;
	private BigDecimal balance;// 流水产生之后系统账户的可用余额;
	private BigDecimal freezedAmount;// 流水产生之后系统账户的冻结余额;
	private Long systemAccountId;// 对应的系统账户的id
}
