package com.xmg.p2p.base.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


/**
 * 基础的审核对象
 * @author 14847
 *
 */

@Getter
@Setter
 abstract public class BaseAuditDomain extends BaseDomain {
	
	public static final int STATE_NORMAL = 0;//正常		
	public static final int STATE_AUDIT = 1;//审核通过
	public static final int STATE_REJECT = 2;//审核拒绝

	
	protected String remark;//审核备注
	protected int state;//状态
	protected Logininfo applier;//申请人
	protected Logininfo auditor;//审核人
	protected Date applyTime;//申请时间
	protected Date auditTime;//审核时间
	
	public String getStateDisplay(){
		switch (state) {
		case STATE_NORMAL:
			return "待审核";
		case STATE_AUDIT:
			return "审核通过";
		case STATE_REJECT:
			return "审核拒绝";
		default:
			return  "";
		}
	}
}
