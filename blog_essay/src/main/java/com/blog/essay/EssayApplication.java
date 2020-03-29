package com.blog.essay;

import com.blog.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = "com.blog")
@EntityScan(value="com.blog.domain")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class EssayApplication {
    /**
     * 启动方法
     */
    public static void main(String[] args) {
        SpringApplication.run(EssayApplication.class,args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

}
