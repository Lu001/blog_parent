package com.blog.essay.dao;

import com.blog.domain.essay.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TagDao extends JpaRepository<Tag,String>,JpaSpecificationExecutor<Tag> {
}
