package com.blog.essay.service;

import com.blog.common.service.BaseService;
import com.blog.common.utils.IdWorker;
import com.blog.domain.essay.Tag;
import com.blog.essay.dao.TagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService extends BaseService {

    @Autowired
    TagDao tagDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 1.根据id查询分类
     */
    public Tag findById(String id) {
        return tagDao.findById(id).get();
    }
}
