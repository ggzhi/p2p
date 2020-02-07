package com.xmg.mgrsite.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xmg.p2p.base.query.IplogQueryObject;
import com.xmg.p2p.base.service.IIplogService;

/**
 * 后台查询登录日志
 * @author 14847
 *
 */
@Controller
public class IplogController {
	
	@Autowired
	private IIplogService iplogService;
	
	@RequestMapping("ipLog")
	public String ipLog(@ModelAttribute("qo") IplogQueryObject qo, Model model){
		model.addAttribute("pageResult", iplogService.query(qo));
		return "ipLog/list";
	}
}
