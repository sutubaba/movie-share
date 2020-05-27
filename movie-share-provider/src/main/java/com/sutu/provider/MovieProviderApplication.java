package com.sutu.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@SpringBootApplication
@EnableFeignClients
public class MovieProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieProviderApplication.class);
    }
}
