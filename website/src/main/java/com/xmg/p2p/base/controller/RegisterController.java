package com.xmg.p2p.base.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.domain.Logininfo;
import com.xmg.p2p.base.service.ILogininfoService;
import com.xmg.p2p.base.util.JSONResult;

/**
 * 用于注册登录相关
 * @author 14847
 *
 */
@Controller
public class RegisterController {
	
	@Autowired
	private ILogininfoService logininfoService;
	
	@RequestMapping("register")
	@ResponseBody
	public JSONResult register(String username , String password){
		
		JSONResult json = new JSONResult();
		try{
			logininfoService.register(username, password);
		}catch (RuntimeException re){
			json.setSuccess(false);
			json.setMsg(re.getMessage());
		}
		return json;
	}
	
	
	@RequestMapping("checkUsername")
	@ResponseBody
	public Boolean checkUsername(String username){
		return !this.logininfoService.checkUsername(username);
	}
	
	
	@RequestMapping("login")
	@ResponseBody
	public JSONResult login(String username,String password,
			HttpServletRequest request){
		JSONResult json = new JSONResult();
		Logininfo current = this.logininfoService.login(username, password,
					request.getRemoteAddr(),Logininfo.USER_CLIENT);
			if (current == null){
				json.setSuccess(false);
				json.setMsg("用户名或者密码错误");
			}
		return json;
	}
	}

