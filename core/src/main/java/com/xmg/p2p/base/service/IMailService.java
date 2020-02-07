package com.xmg.p2p.base.service;

/**
 * 专门用于发送邮件的服务
 * @author 14847
 *
 */
public interface IMailService {
	
	/**
	 * 
	 * @param target
	 * 			目标邮件地址
	 * @param title
	 * @param content
	 */
	void  sendMail(String target,String title, String content);
}
