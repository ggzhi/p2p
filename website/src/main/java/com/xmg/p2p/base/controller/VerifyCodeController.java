package com.xmg.p2p.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.service.IVerifyCodeService;
import com.xmg.p2p.base.util.JSONResult;

/**
 * 验证码1相关的controller
 * @author 14847
 *
 */
@Controller
public class VerifyCodeController {
	
	@Autowired
	private IVerifyCodeService verifyCodeService;
	
	@RequestMapping("sendVerifyCode")
	@ResponseBody
	public JSONResult sendVerifyCode(String phoneNumber){
		JSONResult json = new JSONResult();
		try{
			verifyCodeService.sendVerifyCode(phoneNumber);
		}catch(RuntimeException re){
			json.setMsg(re.getMessage());
			json.setSuccess(false);
		}
		return json;
	}
}
