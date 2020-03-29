package com.blog.essay.service;

import com.blog.common.service.BaseService;
import com.blog.common.utils.IdWorker;
import com.blog.domain.essay.Comment;
import com.blog.essay.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends BaseService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 1.根据id查询分类
     */
    public Comment findById(String id) {
        return commentDao.findById(id).get();
    }
}
