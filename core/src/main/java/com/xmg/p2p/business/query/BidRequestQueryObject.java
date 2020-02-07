package com.xmg.p2p.business.query;

import com.xmg.p2p.base.query.QueryObject;

import lombok.Getter;
import lombok.Setter;
/**
 * 查询借款
 * @author 14847
 *
 */
@Getter
@Setter
public class BidRequestQueryObject extends QueryObject {
	
	private int bidRequestState = -1;//借款状态
	private int[] bidRequestStates;//要查询的多个借款状态
	
	private String orderBy;//按照哪个列排序
	private String orderType;//按照什么顺序排列
	
}
