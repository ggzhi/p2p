package com.xmg.mgrsite.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.query.UserFileQueryObject;
import com.xmg.p2p.base.service.IUserFileService;
import com.xmg.p2p.base.util.JSONResult;

/**
 * 风控资料审核
 * @author 14847
 *
 */
@Controller
public class UserFileController {
	
	@Autowired
	private IUserFileService userFileService;
	
	@RequestMapping("userFileAuth")
	public String userFileAuthList(@ModelAttribute("qo")UserFileQueryObject qo,Model model){
		model.addAttribute("pageResult",this.userFileService.query(qo));
		return "userFileAuth/list";
	}
	
	/**
	 * 审核
	 */
	@RequestMapping("userFile_audit")
	@ResponseBody
	public JSONResult audit(Long id,int score,String remark,int state){
		this.userFileService.audit(id,score,remark,state);
		return new JSONResult();
	}
}
