package com.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author chenchao
 * @Date 11:48 2020/3/1
 * @Description
 * @Param
 * @return
 **/

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class EurakeServerAppliction {
    public static void main(String[] args) {
        SpringApplication.run(EurakeServerAppliction.class);
    }
}
