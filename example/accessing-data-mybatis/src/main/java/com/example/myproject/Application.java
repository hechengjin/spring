package com.example.myproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by hechengjin on 17-7-28.
 */
@SpringBootApplication
@ComponentScan({"com.example.myproject.*","com.example.mybatis.mysql.dao.*","com.example.common.*"})
@MapperScan({"com.example.mybatis.mysql.sqlmapper.*"})
//@EnableWebMvc
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
