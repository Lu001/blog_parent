package com.blog.domain.essay;

import com.blog.domain.system.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by limi on 2017/10/14.
 */
@Entity
@Table(name = "t_blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class Blog implements Serializable {
    private static final long serialVersionUID = 4297464181093070302L;
    @Id
    private String id;
    /**
     * 博客标题
     */
    private String title;
    /**
     * 博客内容
     */
    private String content;
    /**
     *首图
     */
    private String firstPicture;
    /**
     *标志
     */
    private String flag;
    /**
     *浏览次数
     */
    private Integer views;
    /**
     *赞赏是否开启
     */
    private boolean appreciation;
    /**
     * 转载声明是否开启
     */
    private boolean shareStatement;
    /**
     * 评论是否开启
     */
    private boolean commentabled;
    /**
     * 发布状态
     */
    private boolean published;
    /**
     * 是否推荐
     */
    private boolean recommend;
    /**
     * 描述信息
     */
    private String description;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="t_blog_tags",joinColumns={@JoinColumn(name="blogs_id",referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="tags_id",referencedColumnName="id")}
    )
    private Set<Tag> tags = new HashSet<>();


    @ManyToOne
    private Type type;

   @ManyToOne
   private User user;

//    @OneToMany(mappedBy = "blog")
//    private List<Comment> comments = new ArrayList<>();


//    @Transient
//    private String tagIds;


}
