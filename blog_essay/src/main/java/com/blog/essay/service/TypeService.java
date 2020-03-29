package com.blog.essay.service;

import com.blog.common.service.BaseService;
import com.blog.common.utils.IdWorker;
import com.blog.domain.essay.Type;
import com.blog.essay.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService extends BaseService {

    @Autowired
    TypeDao typeDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 1.根据id查询分类
     */
    public Type findById(String id) {
        return typeDao.findById(id).get();
    }

}
