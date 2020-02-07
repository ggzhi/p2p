package com.xmg.p2p.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.util.JSONResult;
import com.xmg.p2p.base.util.RequireLogin;
import com.xmg.p2p.base.util.UserContext;
import com.xmg.p2p.business.domain.RechargeOffline;
import com.xmg.p2p.business.query.RechargeOfflineQueryObject;
import com.xmg.p2p.business.service.IPlatformBankInfoService;
import com.xmg.p2p.business.service.IRechargeOfflineService;

/**
 * 前台的线下充值
 * @author 14847
 *
 */
@Controller
public class RechargeOfflineController {
	
	@Autowired
	private IPlatformBankInfoService platformBankInfoService;
	
	@Autowired
	private IRechargeOfflineService rechargeOfflineService;
	
	
	/**
	 * 导向到线下充值页面
	 * @param model
	 * @return
	 */
	@RequireLogin
	@RequestMapping("recharge")
	public String recharge(Model model){
		model.addAttribute("banks",this.platformBankInfoService.listAll());
		return "recharge";
	}
	
	@RequireLogin
	@RequestMapping("recharge_list")
	public String rechargeList(
			@ModelAttribute("qo") RechargeOfflineQueryObject qo, Model model) {
		qo.setApplierId(UserContext.getCurrent().getId());
		model.addAttribute("pageResult", this.rechargeOfflineService.query(qo));
		return "recharge_list";
	}
	
	
	@RequireLogin
	@RequestMapping("recharge_save")
	@ResponseBody
	public JSONResult rechargeApply(RechargeOffline recharge){
		this.rechargeOfflineService.apply(recharge);
		return new JSONResult();
	}
}
