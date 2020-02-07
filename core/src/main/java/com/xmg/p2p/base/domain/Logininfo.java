package com.xmg.p2p.base.domain;

import lombok.Getter;

import lombok.Setter;

/**
 * 代表用户登录信息
 * @author 14847
 *
 */
@Getter
@Setter
public class Logininfo extends BaseDomain{
	
	public static final int STATE_NORMAL = 0;//正常
	public static final int STATE__LOCK = 1;//锁定
	
	public static final int USER_MANAGER = 0;//前台用户
	public static final int USER_CLIENT = 1;//后台用户
	
	private String username;
	private String password;
	private int state;
	private int userType;
}
