package com.blog.essay.service;

import com.blog.common.service.BaseService;
import com.blog.common.utils.IdWorker;
import com.blog.domain.essay.Blog;
import com.blog.essay.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService extends BaseService {

    @Autowired
    BlogDao blogDao;

    @Autowired
    private IdWorker idWorker;
    /**
     * 1.保存博客
     */
    public void save(Blog blog) {
        //设置主键的值
        String id = idWorker.nextId()+"";
        blog.setId(id);
        //调用dao保存博客
        blogDao.save(blog);
    }

    /**
     * 2.根据id查询博客
     */
    public Blog findById(String id) {
        return blogDao.findById(id).get();
    }

}
