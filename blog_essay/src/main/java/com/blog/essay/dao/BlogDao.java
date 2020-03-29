package com.blog.essay.dao;

import com.blog.domain.essay.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogDao extends JpaRepository<Blog,String>,JpaSpecificationExecutor<Blog> {
}
