package com.lxl;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.lxl")
@ComponentScan(basePackages = {"com.lxl"})
@EnableAutoConfiguration
@ServletComponentScan("com.lxl.service")
@MapperScan({"com.lxl.mapper","com.baomidou.mybatisplus.core.mapper"})
public class OsgiProjectApplication {
    public static void main(String[] args){

        SpringApplication.run(OsgiProjectApplication.class,args);


    }
}
