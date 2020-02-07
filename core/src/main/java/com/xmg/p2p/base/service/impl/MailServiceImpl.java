package com.xmg.p2p.base.service.impl;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.xmg.p2p.base.service.IMailService;

@Service
public class MailServiceImpl implements IMailService {
	
	@Value("${mail.host}")
	private String host;
	
	@Value("${mail.username}")
	private String username;
	
	@Value("${mail.password}")
	private String password;
	
	@Override
	public  void sendMail(String target, String title, String content) {
		try{
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		//设置SMTP服务器地址
		sender.setHost(host);
		//创建好一个邮件对象
		MimeMessage message = sender.createMimeMessage();
		//创建一个邮件助手
		MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");
		//通过heloper设置邮件相关内容
		//设置目标
		helper.setTo(target);
		//设置from
		helper.setFrom("Admin@xmg.com","系统管理员");
		//设置邮件标题
		helper.setSubject(title);
		//设置邮件内容
		helper.setText(content, true);
		
		//设置发送邮件的账号和密码
		sender.setUsername(username);
		sender.setPassword(password);
		
		//
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");//设置发送邮件需要身份认证
		prop.put("mail.smtp.timeout", 25000);//设置发送超时时间
		
		sender.setJavaMailProperties(prop);
		//发送邮件
		sender.send(message);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("发送邮件失败");
		}
	}

}
