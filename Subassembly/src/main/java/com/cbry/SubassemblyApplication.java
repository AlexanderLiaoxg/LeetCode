package com.cbry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling	//开启Spring的定时调度注解
@SpringBootApplication
public class SubassemblyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubassemblyApplication.class, args);
    }

}
