package com.blog.domain.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类
 */
@Entity
@Table(name = "bs_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 4297464181093070302L;
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 启用状态 0为禁用 1为启用
     */
    private Integer enableState;

    private String consumerId;

    private String consumerName;

    /**
     * level
     *     String
     *          saasAdmin：saas管理员具备所有权限
     *          coAdmin：企业管理（创建租户企业的时候添加）
     *          user：普通用户（需要分配角色）
     */
    private String level;

    public User(Object [] values) {
        this.username = values[1].toString();
        this.mobile = values[2].toString();
    }

    /**
     *  JsonIgnore
     *     : 忽略json转化
     */
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="pe_user_role",joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="id")}
    )
    private Set<Role> roles = new HashSet<Role>();//用户与角色   多对多
}
