package com.cafe.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cafe.manager"})
@EnableTransactionManagement
public class CafeManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CafeManagerApplication.class, args);
    }

}
