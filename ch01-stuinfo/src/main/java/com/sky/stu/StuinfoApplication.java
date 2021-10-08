package com.sky.stu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sky.stu.mapper")
public class StuinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuinfoApplication.class, args);
    }

}
