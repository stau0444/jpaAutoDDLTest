package com.example.jpaautoddltset.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Content {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String body;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<Comment> comments;
}
