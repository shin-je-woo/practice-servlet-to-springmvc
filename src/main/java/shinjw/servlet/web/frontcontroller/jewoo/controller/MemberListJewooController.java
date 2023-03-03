package shinjw.servlet.web.frontcontroller.jewoo.controller;

import shinjw.servlet.domain.member.Member;
import shinjw.servlet.domain.member.MemberRepository;
import shinjw.servlet.web.frontcontroller.jewoo.JewooController;
import shinjw.servlet.web.frontcontroller.jewoo.JewooView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListJewooController implements JewooController {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public JewooView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);
        String viewPath = "/WEB-INF/views/members.jsp";
        return new JewooView(viewPath);
    }
}
