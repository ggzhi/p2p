package com.xmg.p2p.base.domain;

import java.math.BigDecimal;

import com.xmg.p2p.base.util.BidConst;
import com.xmg.p2p.base.util.MD5;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户对应的账户信息
 * @author 14847
 *
 */
@Setter
@Getter
public class Account extends BaseDomain{
	
	//对象版本信息
	private int version;
	//交易密码
	private String tradePassword;
	//账户可用金额
	private BigDecimal usableAmount=BidConst.ZERO;
	//账户冻结金额
	private BigDecimal freezedAmount=BidConst.ZERO;
	//账户代收利息
	private BigDecimal unReceiveInterest=BidConst.ZERO;
	//账户代收本金
	private BigDecimal unReceivePrincipal=BidConst.ZERO;
	//账户代还金额
	private BigDecimal unReturnAmount=BidConst.ZERO;
	//账户剩余授信额度
	private BigDecimal remainBorrowLimit=BidConst.INIT_BORROW_LIMIT;
	//账户授信额度
	private BigDecimal borrowLimit=BidConst.INIT_BORROW_LIMIT;
	
	private String verifyCode;//做数据校验的
	
	public String getVerifyCode(){
		return MD5.encode(usableAmount.hashCode() + " "
				+ freezedAmount.hashCode());
	}
	
	public boolean checkVerifyCode(){
		return MD5.encode(usableAmount.hashCode() + " "
				+ freezedAmount.hashCode()).equals(verifyCode);
	}
	
	public BigDecimal getTotalAmount(){
		return usableAmount.add(this.freezedAmount).add(this.unReceivePrincipal);
	}
}
