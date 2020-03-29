package com.blog.domain.essay;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by limi on 2017/10/14.
 */
@Entity
@Table(name = "t_tag")
@Getter
@Setter
public class Tag  implements Serializable {
    private static final long serialVersionUID = -1002411490113957485L;
    @Id
    private String id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy="tags")  //不维护中间表
    private Set<Blog> users = new HashSet<Blog>(0);//角色与用户   多对多

}
