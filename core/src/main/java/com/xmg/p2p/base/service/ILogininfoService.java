package com.xmg.p2p.base.service;

import com.xmg.p2p.base.domain.Logininfo;

/**
 * 登录相关服务 
 * @author 14847
 *
 */
public interface ILogininfoService {
	
	/**
	 * 用户注册
	 * @param username
	 * @param password
	 */
	void register(String username, String password);

	/**
	 * 检查用户名是否存在
	 * 如果存在，返回true
	 * 如果不存在，返回false
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);
	
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param string 
	 * @return 
	 */
	Logininfo login (String username,String password, String ip, int userType);
	
	/**
	 * 初始化第一个管理员
	 */
	void initAdmin();

	

	

	

	
}
