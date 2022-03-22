package com.example.jpaautoddltset.controller;

import com.example.jpaautoddltset.dto.CommentReq;
import com.example.jpaautoddltset.entity.Comment;
import com.example.jpaautoddltset.entity.Member;
import com.example.jpaautoddltset.repository.CommentRepository;
import com.example.jpaautoddltset.repository.ContentRepository;
import com.example.jpaautoddltset.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
    private CommentRepository commentRepository;
    private ContentRepository contentRepository;
    private MemberRepository memberRepository;

    @PostMapping("")
    private String saveComment(@RequestBody CommentReq req){
        Member member = memberRepository.findByName(req.getMemberName());
        Comment comment = Comment.builder()
                .comment(req.getComment())
                .content(contentRepository.getById(req.getContentId()))
                .member(member)
                .createAt(LocalDateTime.now())
                .repliedCommentId(req.getRepliedCommentId())
                .build();
        commentRepository.save(comment);
        return "댓글 저장됨";
    }
}
