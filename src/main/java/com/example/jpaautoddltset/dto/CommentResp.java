package com.example.jpaautoddltset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResp {
    private String comment;
    private Long id;
    private String memberName;
    private Long repliedCommentId;
    private String createAt;
}
