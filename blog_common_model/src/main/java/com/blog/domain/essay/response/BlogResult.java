package com.blog.domain.essay.response;

import com.blog.domain.essay.Blog;
import com.blog.domain.essay.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BlogResult implements Serializable {

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

    private List<String> tagsId = new ArrayList<>();

    public BlogResult(Blog blog) {
        BeanUtils.copyProperties(blog,this);
        for (Tag tag : blog.getTags()) {
            this.tagsId.add(tag.getId());
        }
    }
}
