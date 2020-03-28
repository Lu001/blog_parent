package com.blog.customer;

import com.blog.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;


//1.配置springboot的包扫描
@SpringBootApplication(scanBasePackages = "com.blog")
//2.配置jpa注解的扫描
@EntityScan(value="com.blog.domain.customer")
public class CustomerApplication {

    /**
     * 启动方法
     */
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class,args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

}
