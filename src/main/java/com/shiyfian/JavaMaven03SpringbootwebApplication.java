package com.shiyfian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync//开始异步功能
@EnableScheduling//开始定时功能
public class JavaMaven03SpringbootwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMaven03SpringbootwebApplication.class, args);
    }

}
