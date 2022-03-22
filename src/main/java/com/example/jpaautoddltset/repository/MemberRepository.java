package com.example.jpaautoddltset.repository;

import com.example.jpaautoddltset.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByName(String name);
}
