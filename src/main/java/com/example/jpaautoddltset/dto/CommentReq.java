package com.example.jpaautoddltset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentReq {
    private String memberName;
    private Long contentId;
    private String comment;
    private Long repliedCommentId;
}
