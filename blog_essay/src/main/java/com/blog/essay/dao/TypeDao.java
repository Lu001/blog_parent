package com.blog.essay.dao;

import com.blog.domain.essay.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeDao extends JpaRepository<Type,String>,JpaSpecificationExecutor<Type> {
}
