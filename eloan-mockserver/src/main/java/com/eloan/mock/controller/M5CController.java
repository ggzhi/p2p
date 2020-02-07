package com.eloan.mock.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class M5CController extends BaseController {

	@RequestMapping("/send")
	@ResponseBody
	public String send(String username, String password, String apikey, String mobile, String content) {
		System.out.println("发送短信给手机：" + mobile + "，发送短信内容为：" + content);
		return "success:" + UUID.randomUUID().toString();
	}
}
