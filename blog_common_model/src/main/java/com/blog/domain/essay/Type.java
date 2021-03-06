package com.blog.domain.essay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by limi on 2017/10/14.
 */
@Entity
@Table(name = "t_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type  implements Serializable {
    private static final long serialVersionUID = 4297464181093070302L;
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "type")
    @Column(name = "type_id")
    private List<Blog> blogs = new ArrayList<>();
}
