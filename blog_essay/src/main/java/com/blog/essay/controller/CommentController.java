package com.blog.essay.controller;

import com.blog.common.controller.BaseController;
import com.blog.common.entity.Result;
import com.blog.common.entity.ResultCode;
import com.blog.domain.essay.Comment;
import com.blog.essay.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/essay")
public class CommentController extends BaseController{
    
    @Autowired
    private CommentService commentService;
    /**
     * 根据ID获取博客信息
     */
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Comment comment = commentService.findById(id);
        return new Result(ResultCode.SUCCESS,comment);
    }


}
