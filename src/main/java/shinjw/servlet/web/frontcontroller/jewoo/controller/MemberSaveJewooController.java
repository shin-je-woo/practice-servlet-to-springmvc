package shinjw.servlet.web.frontcontroller.jewoo.controller;

import shinjw.servlet.domain.member.Member;
import shinjw.servlet.domain.member.MemberRepository;
import shinjw.servlet.web.frontcontroller.jewoo.JewooController;
import shinjw.servlet.web.frontcontroller.jewoo.JewooModelView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberSaveJewooController implements JewooController {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public JewooModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        JewooModelView modelView = new JewooModelView("save-result");
        modelView.getModel().put("member", member);
        return modelView;
    }
}
