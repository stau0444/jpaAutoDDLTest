package com.example.jpaautoddltset.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentResp {
    private Long contentId;
    private String title;
    private String body;
}
