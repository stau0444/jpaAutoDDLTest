package com.example.jpaautoddltset.dto;

import com.example.jpaautoddltset.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentResp {
    private Long contentId;
    private String title;
    private String body;
    private List<CommentResp> commentList;
}
