package com.cc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author chenchao
 * @Date 11:36 2020/2/29
 * @Description
 * @Param
 * @return
 **/
@SpringBootApplication
@MapperScan("com.cc.dao")
public class HardwareAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(HardwareAPIApplication.class);
    }

}
