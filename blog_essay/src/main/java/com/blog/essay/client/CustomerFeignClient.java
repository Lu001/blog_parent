package com.blog.essay.client;

import com.blog.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 声明接口，通过feign调用其他微服务
 */
//声明调用的微服务名称
@FeignClient("blog-consumer")
public interface CustomerFeignClient {
    /**
     * 调用微服务的接口
     */
    @RequestMapping(value="/customer/{id}",method = RequestMethod.GET)
    Result findById(@PathVariable(value="id") String id);
}
