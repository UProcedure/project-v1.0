package com.weimin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO springboot启动类
 * @author weimin
 */
@SpringBootApplication
@MapperScan("com.weimin.user.mapper")
public class V1Application {

    public static void main(String[] args) {
        SpringApplication.run(V1Application.class, args);
    }

}
