package com.xmg.mgrsite.base;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.domain.UserFile;
import com.xmg.p2p.base.domain.Userinfo;
import com.xmg.p2p.base.query.UserFileQueryObject;
import com.xmg.p2p.base.service.IRealAuthService;
import com.xmg.p2p.base.service.IUserFileService;
import com.xmg.p2p.base.service.IUserinfoService;

import com.xmg.p2p.base.util.BidConst;
import com.xmg.p2p.base.util.JSONResult;
import com.xmg.p2p.business.domain.BidRequest;

import com.xmg.p2p.business.query.BidRequestQueryObject;
import com.xmg.p2p.business.service.IBidRequestService;

/**
 * 借款相关controller
 * @author 14847
 *
 */
@Controller
public class BidRequestController {
	
	@Autowired
	private IBidRequestService bidRequestService;

	@Autowired
	private IUserinfoService userinfoService;

	@Autowired
	private IRealAuthService realAuthService;

	@Autowired
	private IUserFileService userFileService;

	@RequestMapping("bidrequest_publishaudit_list")
	public String bidRequestPublishAuditList(
			@ModelAttribute("qo") BidRequestQueryObject qo, Model model) {
		qo.setBidRequestState(BidConst.BIDREQUEST_STATE_PUBLISH_PENDING);
		model.addAttribute("pageResult", this.bidRequestService.query(qo));
		return "bidrequest/publish_audit";
	}

	/**
	 * 发表前审核
	 * 
	 * @return
	 */
	@RequestMapping("bidrequest_publishaudit")
	@ResponseBody
	public JSONResult bidRequestPublishAudit(Long id, String remark, int state) {
		this.bidRequestService.publishAudit(id, remark, state);
		return new JSONResult();
	}

	/**
	 * 满标一审列表
	 */
	@RequestMapping("bidrequest_audit1_list")
	public String bidRequestFullAudit1List(
			@ModelAttribute("qo") BidRequestQueryObject qo, Model model) {
		qo.setBidRequestState(BidConst.BIDREQUEST_STATE_APPROVE_PENDING_1);
		model.addAttribute("pageResult", this.bidRequestService.query(qo));
		return "bidrequest/audit1";
	}

	/**
	 * 满标一审
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 * @return
	 */
	@RequestMapping("bidrequest_audit1")
	@ResponseBody
	public JSONResult bidRequestAudit1(Long id, String remark, int state) {
		this.bidRequestService.fullAudit1(id, remark, state);
		return new JSONResult();
	}

	/**
	 * 满标二审列表
	 */
	@RequestMapping("bidrequest_audit2_list")
	public String bidRequestFullAudit2List(
			@ModelAttribute("qo") BidRequestQueryObject qo, Model model) {
		qo.setBidRequestState(BidConst.BIDREQUEST_STATE_APPROVE_PENDING_2);
		model.addAttribute("pageResult", this.bidRequestService.query(qo));
		return "bidrequest/audit2";
	}
	
	/**
	 * 满标二审
	 * 
	 * @param id
	 * @param remark
	 * @param state
	 * @return
	 */
	@RequestMapping("bidrequest_audit2")
	@ResponseBody
	public JSONResult bidRequestAudit2(Long id, String remark, int state) {
		this.bidRequestService.fullAudit2(id, remark, state);
		return new JSONResult();
	}
	

	/**
	 * 后台查看借款详情
	 */
	@RequestMapping("borrow_info")
	public String borrowInfoDetail(Long id, Model model) {
		// bidRequest;
		BidRequest bidRequest = this.bidRequestService.get(id);
		Userinfo userinfo = this.userinfoService.get(bidRequest.getCreateUser()
				.getId());
		model.addAttribute("bidRequest", bidRequest);
		// userInfo
		model.addAttribute("userInfo", userinfo);
		// audits:这个标的审核历史
		model.addAttribute("audits",
				this.bidRequestService.listAuditHistoryByBidRequest(id));
		// realAuth:借款人实名认证信息
		model.addAttribute("realAuth",
				this.realAuthService.get(userinfo.getRealAuthId()));
		// userFiles:该借款人的风控资料信息
		UserFileQueryObject qo = new UserFileQueryObject();
		qo.setApplierId(userinfo.getId());
		qo.setState(UserFile.STATE_AUDIT);
		qo.setPageSize(-1);
		model.addAttribute("userFiles", this.userFileService.queryForList(qo));
		return "bidrequest/borrow_info";
	}
}