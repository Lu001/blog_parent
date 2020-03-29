package com.blog.essay.controller;

import com.blog.common.controller.BaseController;
import com.blog.common.entity.Result;
import com.blog.common.entity.ResultCode;
import com.blog.domain.essay.Blog;
import com.blog.domain.essay.response.BlogResult;
import com.blog.essay.client.CustomerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.blog.essay.service.BlogService;

@CrossOrigin
@RestController
@RequestMapping("/essay")
public class BlogController extends BaseController{
    
    @Autowired
    private BlogService blogService;
    @Autowired
    private CustomerFeignClient customerFeignClient;
    /**
     * 根据ID获取博客信息
     */
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Blog blog = blogService.findById(id);
        BlogResult blogResult = new BlogResult(blog);
        return new Result(ResultCode.SUCCESS,blogResult);
    }

    /**
     * 测试Feign组件
     * 调用系统微服务的/test接口传递部门id，通过feign调用部门微服务获取部门信息
     */
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public Result testFeign(@PathVariable(value = "id") String id) {
        Result result = customerFeignClient.findById(id);
        return result;
    }


}
