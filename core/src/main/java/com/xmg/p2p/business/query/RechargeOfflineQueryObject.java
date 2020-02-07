package com.xmg.p2p.business.query;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.query.AuditQueryObject;
import com.xmg.p2p.base.util.JSONResult;

import lombok.Getter;
import lombok.Setter;

/**
 * 线下充值查询
 * @author 14847
 *
 */
@Getter
@Setter
public class RechargeOfflineQueryObject  extends AuditQueryObject{
	
	private Long applierId;
	private Long bankInfoId;//按照开户行查询
	private String tradeCode;
	
	public String getTradeCode(){
		return StringUtils.hasLength(tradeCode) ? tradeCode : null;
	}
	
	
}
	

