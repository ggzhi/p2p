package com.xmg.p2p.base.util;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 专门用于登录检查的拦截器
 * @author 14847
 *
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//判断登录逻辑
		if(handler instanceof HandlerMethod){
			HandlerMethod hm = (HandlerMethod) handler;
			RequireLogin rl = hm.getMethodAnnotation(RequireLogin.class);
			if(rl!=null && UserContext.getCurrent()==null){
				response.sendRedirect("/login.html");
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}

	

}
