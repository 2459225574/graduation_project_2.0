package com.itstyle.cloud.common.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itstyle.cloud.common.entity.ApplicationConfig;
import com.itstyle.cloud.common.entity.SysUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 日志(认证)拦截器
 * 创建者 张志朋
 * 创建时间	2017年9月26日
 */
public class SysInterceptor  implements HandlerInterceptor {
	@Value("${address.user-system}")
	private String userSystemAddr;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {

		System.out.println("***********************hardware_drive拦截路径："+request.getRequestURI()+"*************************");
		//拦截所有请求
		//使用ribbon请求用户模块去验证用户是否登录

		SysUser user =  (SysUser) request.getSession().getAttribute("user");
		if(user==null){
			response.sendRedirect(ApplicationConfig.USER_MANAGE_SYSTEM+"/member/login");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
		
	}

}
