 package com.xmg.p2p.business.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.p2p.base.domain.Account;
import com.xmg.p2p.base.util.BidConst;
import com.xmg.p2p.business.domain.AccountFlow;
import com.xmg.p2p.business.domain.Bid;
import com.xmg.p2p.business.domain.BidRequest;
import com.xmg.p2p.business.domain.MoneyWithdraw;
import com.xmg.p2p.business.domain.PaymentSchedule;
import com.xmg.p2p.business.domain.PaymentScheduleDetail;
import com.xmg.p2p.business.domain.RechargeOffline;
import com.xmg.p2p.business.mapper.AccountFlowMapper;

import com.xmg.p2p.business.service.IAccountFlowService;

@Service
public class AccountFlowServiceImpl implements IAccountFlowService {

	@Autowired
	private AccountFlowMapper accountFlowMapper;

	private AccountFlow createBaseFlow(Account account) {
		AccountFlow flow = new AccountFlow();
		flow.setAccountId(account.getId());
		flow.setTradeTime(new Date());
		flow.setUsableAmount(account.getUsableAmount());
		flow.setFreezedAmount(account.getFreezedAmount());
		return flow;
	}

	@Override
	public void rechargeFlow(RechargeOffline r, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_RECHARGE_OFFLINE);
		flow.setAmount(r.getAmount());
		flow.setNote("线下充值成功,充值金额:" + r.getAmount());
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void bid(Bid bid, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_BID_FREEZED);
		flow.setAmount(bid.getAvailableAmount());
		flow.setNote("投标" + bid.getBidRequestTitle() + ",冻结账户余额:"
				+ bid.getAvailableAmount());
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void returnMoney(Bid bid, Account bidAccount) {
		AccountFlow flow = createBaseFlow(bidAccount);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_BID_UNFREEZED);
		flow.setAmount(bid.getAvailableAmount());
		flow.setNote("投标" + bid.getBidRequestTitle() + ",满审拒绝退款:"
				+ bid.getAvailableAmount());
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void borrowSuccess(BidRequest br, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_BIDREQUEST_SUCCESSFUL);
		flow.setAmount(br.getBidRequestAmount());
		flow.setNote("借款" + br.getTitle() + "成功,收到借款金额:"
				+ br.getBidRequestAmount());
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void borrowChargeFee(BigDecimal manageChargeFee, BidRequest br,
			Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_CHARGE);
		flow.setAmount(manageChargeFee);
		flow.setNote("借款" + br.getTitle() + "成功,支付借款手续费:" + manageChargeFee);
		this.accountFlowMapper.insert(flow);

	}

	@Override
	public void bidSuccess(Bid bid, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_BID_SUCCESSFUL);
		flow.setAmount(bid.getAvailableAmount());
		flow.setNote("投标" + bid.getBidRequestTitle() + "成功,取消投标冻结金额:"
				+ bid.getAvailableAmount());
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void moneyWithDrawApply(MoneyWithdraw m, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_WITHDRAW_FREEZED);
		flow.setAmount(m.getAmount());
		flow.setNote("提现申请,冻结金额:" + m.getAmount());
		this.accountFlowMapper.insert(flow);

	}

	@Override
	public void withDrawFailed(MoneyWithdraw m, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_WITHDRAW_UNFREEZED);
		flow.setAmount(m.getAmount());
		flow.setNote("提现申请失败,取消冻结金额:" + m.getAmount());
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void withDrawChargeFee(MoneyWithdraw m, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_WITHDRAW_MANAGE_CHARGE);
		flow.setAmount(m.getCharge());
		flow.setNote("提现成功,提现手续费:" + m.getCharge());
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void withDrawSuccess(BigDecimal amount, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_WITHDRAW);
		flow.setAmount(amount);
		flow.setNote("提现成功,提现金额:" + amount);
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void doReturnMoney(PaymentSchedule ps, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_RETURN_MONEY);
		flow.setAmount(ps.getTotalAmount());
		flow.setNote("还款成功,还款金额:" + ps.getTotalAmount());
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void receiveMoney(PaymentScheduleDetail psd, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_CALLBACK_MONEY);
		flow.setAmount(psd.getTotalAmount());
		flow.setNote("回款成功,回款金额:" + psd.getTotalAmount());
		this.accountFlowMapper.insert(flow);
	}

	@Override
	public void interestChargeFee(PaymentScheduleDetail psd,
			BigDecimal interestChargeFee, Account account) {
		AccountFlow flow = createBaseFlow(account);
		flow.setAccountType(BidConst.ACCOUNT_ACTIONTYPE_INTEREST_SHARE);
		flow.setAmount(interestChargeFee);
		flow.setNote("回款成功,回款金额:" + psd.getTotalAmount() + ",支付利息管理费:"
				+ interestChargeFee);
		this.accountFlowMapper.insert(flow);
	}


}
