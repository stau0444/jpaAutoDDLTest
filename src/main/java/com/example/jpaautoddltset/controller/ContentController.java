package com.example.jpaautoddltset.controller;

import com.example.jpaautoddltset.dto.CommentReq;
import com.example.jpaautoddltset.dto.CommentResp;
import com.example.jpaautoddltset.dto.ContentReq;
import com.example.jpaautoddltset.dto.ContentResp;
import com.example.jpaautoddltset.entity.Comment;
import com.example.jpaautoddltset.entity.Content;
import com.example.jpaautoddltset.entity.Member;
import com.example.jpaautoddltset.repository.CommentRepository;
import com.example.jpaautoddltset.repository.ContentRepository;
import com.example.jpaautoddltset.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/content")
@AllArgsConstructor
public class ContentController {

    private ContentRepository contentRepository;
    private MemberRepository memberRepository;
    private CommentRepository commentRepository;


    @GetMapping("/{id}")
    private ContentResp getContent(@PathVariable Long id){
        Content content = contentRepository.getById(id);
        List<CommentResp> commentResp = commentRepository.findAllByContentOrderByCreateAtAsc(contentRepository.getById(id)).stream().map(c ->
             new CommentResp(c.getComment(),c.getContent().getId(), c.getMember().getName(), c.getRepliedCommentId(),c.getCreateAt().format(DateTimeFormatter.ofPattern("MM월dd일 hh:mm:ss")))
        ).collect(Collectors.toList());
        return new ContentResp(content.getId(),content.getTitle(),content.getBody(),commentResp);
    }

    @PostMapping("")
    private String saveContent(@RequestBody ContentReq contentReq){
        Content content = Content.builder()
                .title(contentReq.getTitle())
                .body(contentReq.getBody())
                .member(memberRepository.findById(contentReq.getMemberId()).get())
                .build();
        contentRepository.save(content);
        return "저장됨";
    }

    @GetMapping("/list")
    private List<ContentResp> getContentList(){
        List<Content> contList = contentRepository.findAll();
        return contList.stream()
                .map(c -> new ContentResp(c.getId(), c.getTitle(), c.getBody(),new ArrayList<>()))
                .collect(Collectors.toList());
    }
}
