package com.xmg.p2p.base.vo;



import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 存放验证码相关内容，这个对象是放在session中的
 * @author 14847
 *
 */
@Getter
@Setter
public class VerifyCodeVO {
	
	private String verifyCode;//验证码
	private String phoneNumber;//发送验证码的手机号
	private Date lastSendTime;//最近成功发送时间
}
