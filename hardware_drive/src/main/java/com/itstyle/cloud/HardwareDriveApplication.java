package com.itstyle.cloud;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
@SpringBootApplication
@EnableAsync
public class HardwareDriveApplication extends SpringBootServletInitializer  {
	private static final Logger logger = LoggerFactory.getLogger(HardwareDriveApplication.class);
	
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HardwareDriveApplication.class);
	}
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(HardwareDriveApplication.class, args);
		logger.info("物联网控制驱动资源中心 ");
	}
	@Resource
    private void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
        if(viewResolver != null) {
            Map<String, Object> vars = new HashMap<>();
            vars.put("path", "https://blog.52itstyle.vip");
            viewResolver.setStaticVariables(vars);
        }
    }
}