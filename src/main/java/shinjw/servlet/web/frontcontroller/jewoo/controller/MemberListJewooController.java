package shinjw.servlet.web.frontcontroller.jewoo.controller;

import shinjw.servlet.domain.member.Member;
import shinjw.servlet.domain.member.MemberRepository;
import shinjw.servlet.web.frontcontroller.jewoo.JewooController;
import shinjw.servlet.web.frontcontroller.jewoo.JewooModelView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListJewooController implements JewooController {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public JewooModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        JewooModelView modelView = new JewooModelView("members");
        modelView.getModel().put("members", members);
        return modelView;
    }
}
