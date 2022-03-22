package com.example.jpaautoddltset.controller;

import com.example.jpaautoddltset.dto.MemberReq;
import com.example.jpaautoddltset.entity.Member;
import com.example.jpaautoddltset.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {

    private MemberRepository memberRepository;
    @PostMapping("")
    private String saveMember(@RequestBody MemberReq memberReq){
        memberRepository.save(Member.builder().name(memberReq.getName()).build());
        return "멤버저장";
    }
}
