package com.sutu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@SpringBootApplication
@EnableFeignClients
@RestController
public class MovieWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieWebApplication.class);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
