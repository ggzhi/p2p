package com.xmg.p2p.business.query;

import com.xmg.p2p.base.query.AuditQueryObject;

import lombok.Getter;
import lombok.Setter;

/**
 * 提现申请查询对象
 * @author 14847
 *
 */
@Getter
@Setter
public class MoneyWithdrawQueryObject extends AuditQueryObject {
	
	private Long applierId;
}
