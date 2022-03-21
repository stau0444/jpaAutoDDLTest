package com.example.jpaautoddltset.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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


}
