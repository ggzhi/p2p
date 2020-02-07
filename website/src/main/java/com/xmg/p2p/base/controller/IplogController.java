package com.xmg.p2p.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xmg.p2p.base.query.IplogQueryObject;
import com.xmg.p2p.base.service.IIplogService;
import com.xmg.p2p.base.util.RequireLogin;
import com.xmg.p2p.base.util.UserContext;

/**
 * 登陆日志
 * @author 14847
 *
 */
@Controller
public class IplogController {

	@Autowired
	private IIplogService iplogService;
	
	/**
	 * 个人用户登陆记录列表
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequireLogin
	@RequestMapping("ipLog")
	public String iplogList(@ModelAttribute("qo")IplogQueryObject qo, Model model){
		qo.setUsername(UserContext.getCurrent().getUsername());
		model.addAttribute("pageResult",this.iplogService.query(qo));
		return "iplog_list";
	}
}
