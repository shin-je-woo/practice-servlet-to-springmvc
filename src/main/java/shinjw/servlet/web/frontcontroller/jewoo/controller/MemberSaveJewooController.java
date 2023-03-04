package shinjw.servlet.web.frontcontroller.jewoo.controller;

import shinjw.servlet.domain.member.Member;
import shinjw.servlet.domain.member.MemberRepository;
import shinjw.servlet.web.frontcontroller.jewoo.JewooController;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberSaveJewooController implements JewooController {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);
        return "save-result";
    }
}
