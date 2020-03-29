package com.blog.essay.controller;

import com.blog.common.controller.BaseController;
import com.blog.common.entity.Result;
import com.blog.common.entity.ResultCode;
import com.blog.domain.essay.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.blog.essay.service.BlogService;

@CrossOrigin
@RestController
@RequestMapping("/essay")
public class BlogController extends BaseController{
    
    @Autowired
    private BlogService blogService;
    /**
     * 根据ID获取博客信息
     */
    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Blog blog = blogService.findById(id);
        return new Result(ResultCode.SUCCESS,blog);
    }


}
