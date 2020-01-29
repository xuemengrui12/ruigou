package com.xmr.ruigou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.xmr.ruigou.dao")
@SpringBootApplication
//        (exclude = {DataSourceAutoConfiguration.class})
public class RuigouApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuigouApplication.class, args);
    }

}

