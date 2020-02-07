package com.xmg.p2p.base.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 登录日志
 * @author 14847
 *
 */
@Setter
@Getter
public class Iplog extends BaseDomain {
	public static final int STATE_SUCCESS =1;
	public static final int STATE_FAILED = 0;
	
	//登录ip地址
	private String ip;
	//登录时间
	private Date loginTime;
	//登录姓名
	private String userName;
	//登录状态
	private int state;
	//用户登陆类型
	private int userType;
	
	public String getStateDisplay() {
		return state == STATE_SUCCESS ? "登陆成功" : "登陆失败";
	}
	
	public String getUserTypeDisplay(){
		return userType == Logininfo.USER_CLIENT ? "前端用户" : "后台管理员";
	}
}
