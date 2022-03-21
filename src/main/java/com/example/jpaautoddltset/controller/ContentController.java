package com.example.jpaautoddltset.controller;

import com.example.jpaautoddltset.dto.ContentReq;
import com.example.jpaautoddltset.dto.ContentResp;
import com.example.jpaautoddltset.entity.Content;
import com.example.jpaautoddltset.repository.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/content")
@AllArgsConstructor
public class ContentController {

    private ContentRepository contentRepository;

    @GetMapping("/{id}")
    private ContentResp getContent(@PathVariable Long id){
        Content content = contentRepository.getById(id);
        return new ContentResp(content.getId(),content.getTitle(),content.getBody());
    }

    @PostMapping("")
    private String saveContent(@RequestBody ContentReq contentReq){
        Content content = Content.builder()
                .title(contentReq.getTitle())
                .body(contentReq.getBody())
                .build();
        contentRepository.save(content);
        return "저장됨";
    }

    @GetMapping("/list")
    private List<ContentResp> getContentList(){
        List<Content> contList = contentRepository.findAll();

        return contList.stream()
                .map(c -> new ContentResp(c.getId(), c.getTitle(), c.getBody()))
                .collect(Collectors.toList());
    }
}
