package com.xmg.p2p.base.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.domain.Userinfo;
import com.xmg.p2p.base.service.IAccountService;
import com.xmg.p2p.base.service.IUserinfoService;
import com.xmg.p2p.base.util.JSONResult;
import com.xmg.p2p.base.util.RequireLogin;
import com.xmg.p2p.business.service.IMoneyWithdrawService;
import com.xmg.p2p.business.service.IUserBankinfoService;

@Controller
public class MoneyWithdrawController {
	
	@Autowired
	private IMoneyWithdrawService moneyWithdrawService;
	
	@Autowired
	private IUserinfoService userinfoService;

	@Autowired
	private IUserBankinfoService userBankinfoService;

	@Autowired
	private IAccountService accountService;

	/**
	 * 导向到提现申请界面
	 */
	@RequireLogin
	@RequestMapping("moneyWithdraw")
	public String moenyWithdraw(Model model) {
		Userinfo current = this.userinfoService.getCurrent();
		model.addAttribute("haveProcessing", current.getHasWithdrawProcess());
		model.addAttribute("bankInfo",
				this.userBankinfoService.getByUser(current.getId()));
		model.addAttribute("account", this.accountService.getCurrent());
		return "moneyWithdraw_apply";
	}
	
	/*8
	 * 提现申请
	 */
	@RequireLogin
	@RequestMapping("moneyWithdraw_apply")
	@ResponseBody
	public JSONResult apply(BigDecimal moneyAmount){
		this.moneyWithdrawService.apply(moneyAmount);
		return new JSONResult();
	}
}
