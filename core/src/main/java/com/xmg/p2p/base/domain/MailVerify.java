package com.xmg.p2p.base.domain;





import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MailVerify extends BaseDomain {

	private Long userinfoId;//谁在发送绑定邮箱邮件
	private String email;
	private String uuid;
	private Date sendDate;//发送邮件的时间
	
}
