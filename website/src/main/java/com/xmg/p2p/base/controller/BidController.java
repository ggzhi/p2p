package com.xmg.p2p.base.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.util.JSONResult;
import com.xmg.p2p.base.util.RequireLogin;
import com.xmg.p2p.business.service.IBidRequestService;

@Controller
public class BidController {
	
	@Autowired
	private IBidRequestService bidRequestService;
	
	@RequireLogin
	@RequestMapping("borrow_bid")
	@ResponseBody
	public JSONResult bid(Long bidRequestId,BigDecimal amount){
		this.bidRequestService.bid(bidRequestId, amount);
		return new JSONResult();
	}
}
