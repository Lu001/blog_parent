package com.blog.essay.controller;

import com.blog.common.controller.BaseController;
import com.blog.common.entity.Result;
import com.blog.common.entity.ResultCode;
import com.blog.domain.essay.Tag;
import com.blog.essay.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/essay")
public class TagController extends BaseController{
    
    @Autowired
    private TagService tagService;
    /**
     * 根据ID获取博客信息
     */
    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Tag tag = tagService.findById(id);
        return new Result(ResultCode.SUCCESS,tag);
    }


}
