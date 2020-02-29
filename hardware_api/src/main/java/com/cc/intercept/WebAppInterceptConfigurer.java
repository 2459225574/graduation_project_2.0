package com.cc.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppInterceptConfigurer extends WebMvcConfigurerAdapter {
 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String[] patterns = new String[] {"/login.shtml","/user/login","/logout"};
		registry.addInterceptor(new LoginIntercept())
		                         .addPathPatterns("/**")
		                         .excludePathPatterns(patterns);
		super.addInterceptors(registry);
	}
}