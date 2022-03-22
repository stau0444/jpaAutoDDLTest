package com.example.jpaautoddltset.repository;

import com.example.jpaautoddltset.entity.Comment;
import com.example.jpaautoddltset.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByContentOrderByCreateAtAsc(Content content);
}
