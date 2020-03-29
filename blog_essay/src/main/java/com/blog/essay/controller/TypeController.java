package com.blog.essay.controller;

import com.blog.common.controller.BaseController;
import com.blog.common.entity.Result;
import com.blog.common.entity.ResultCode;
import com.blog.domain.essay.Type;
import com.blog.essay.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/essay")
public class TypeController extends BaseController{
    
    @Autowired
    private TypeService typeService;
    /**
     * 根据ID获取博客信息
     */
    @RequestMapping(value = "/type/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Type type = typeService.findById(id);
        return new Result(ResultCode.SUCCESS,type);
    }

}
