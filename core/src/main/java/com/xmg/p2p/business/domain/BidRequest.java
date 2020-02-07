package com.xmg.p2p.business.domain;

import java.math.BigDecimal;


import java.math.RoundingMode;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.xmg.p2p.base.domain.BaseDomain;
import com.xmg.p2p.base.domain.Logininfo;
import com.xmg.p2p.base.util.BidConst;
import com.xmg.p2p.business.util.DecimalFormatUtil;

import static com.xmg.p2p.base.util.BidConst.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 借款对象
 * @author 14847
 *
 */
@Getter
@Setter
public class BidRequest extends BaseDomain {
	
	private int version;// 版本号
	private int returnType;// 还款类型(等额本息)
	private int bidRequestType;// 借款类型(信用标)
	private int bidRequestState;// 借款状态
	private BigDecimal bidRequestAmount;// 借款总金额
	private BigDecimal currentRate;// 年化利率
	private BigDecimal minBidAmount;// 最小借款金额
	private int monthes2Return;// 还款月数
	private int bidCount = 0;// 已投标次数(冗余)
	private BigDecimal totalRewardAmount;// 总回报金额(总利息)
	private BigDecimal currentSum = ZERO;// 当前已投标总金额
	private String title;// 借款标题
	private String description;// 借款描述
	private String note;// 风控意见
	private Date disableDate;// 招标截止日期
	private int disableDays;// 招标天数
	private Logininfo createUser;// 借款人
	private List<Bid> bids;// 针对该借款的投标
	private Date applyTime;// 申请时间
	private Date publishTime;// 发标时间

	
	/**
	 * 计算当前投标进度
	 */
	public BigDecimal getPersent(){
		return currentSum.divide(bidRequestAmount, BidConst.DISPLAY_SCALE,
				RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
	}
	
	/**
	 * 计算还需金额
	 * @return
	 */
	public BigDecimal getRemainAmount(){
		return DecimalFormatUtil.formatBigDecimal(bidRequestAmount.subtract(currentSum), BidConst.DISPLAY_SCALE);
	}
	
	public String getJsonString() {
		Map<String, Object> json = new HashMap<>();
		json.put("id", id);
		json.put("username", this.createUser.getUsername());
		json.put("title", title);
		json.put("bidRequestAmount", bidRequestAmount);
		json.put("currentRate", currentRate);
		json.put("monthes2Return", monthes2Return);
		json.put("returnType", getReturnTypeDisplay());
		json.put("totalRewardAmount", totalRewardAmount);
		return JSONObject.toJSONString(json);
	}
	
	public String getReturnTypeDisplay() {
		return returnType == BidConst.RETURN_TYPE_MONTH_INTEREST ? "按月到期"
				: "等额本息";
	}

	public String getBidRequestStateDisplay(){
		switch (this.bidRequestState) {
		case BIDREQUEST_STATE_PUBLISH_PENDING:
			return "待发布";
		case BIDREQUEST_STATE_BIDDING:
			return "招标中";
		case BIDREQUEST_STATE_UNDO:
			return "已撤销";
		case BIDREQUEST_STATE_BIDDING_OVERDUE:
			return "流标";
		case BIDREQUEST_STATE_APPROVE_PENDING_1:
			return "满标一审";
		case BIDREQUEST_STATE_APPROVE_PENDING_2:
			return "满标二审";
		case BIDREQUEST_STATE_REJECTED:
			return "满标审核被拒";
		case BIDREQUEST_STATE_PAYING_BACK:
			return "还款中";
		case BIDREQUEST_STATE_COMPLETE_PAY_BACK:
			return "完成";
		case BIDREQUEST_STATE_PAY_BACK_OVERDUE:
			return "逾期";
		case BIDREQUEST_STATE_PUBLISH_REFUSE:
			return "发标拒绝";
		default:
			return "";
		}
	}
	}

