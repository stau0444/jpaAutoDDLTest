package com.example.jpaautoddltset.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Content> contentList;

    @OneToMany(mappedBy = "comment",cascade = CascadeType.ALL)
    private List<Comment> commentList;

}
