package com.xmg.p2p.base.query;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import com.xmg.p2p.base.util.DateUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录日志查询对象
 * @author 14847
 *
 */
@Getter
@Setter
public class IplogQueryObject extends QueryObject {
		
	private Date beginDate;
	private Date endDate;
	private int state = -1;
	private String username;
	private int userType = -1;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setBeginDate(Date beginDate){
		this.beginDate = beginDate;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setEndDate(Date endDate){
		this.endDate = endDate;
	}
	
	public Date getEndDate(){
		return endDate == null ? null : DateUtil.endOfDay(endDate);
	}
	
	public String getUsername(){
		return StringUtils.hasLength(username)  ? username : null;
	}
}
