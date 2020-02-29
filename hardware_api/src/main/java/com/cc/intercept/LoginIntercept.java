package com.cc.intercept;

import com.cc.entity.ApplicationConfig;
import com.cc.entity.UserBaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author chenchao
 * @Date 21:14 2020/2/29
 * @Description
 * @Param
 * @return
 **/
public class LoginIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("***********************hardware_api拦截路径："+httpServletRequest.getRequestURI()+"*************************");
        UserBaseInfo user = (UserBaseInfo) httpServletRequest.getSession().getAttribute("username");
        if (user == null){
            System.out.println(ApplicationConfig.USER_MANAGE_SYSTEM+"/member/login");
            httpServletResponse.sendRedirect(ApplicationConfig.USER_MANAGE_SYSTEM+"/member/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
