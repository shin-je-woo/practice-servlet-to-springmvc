package shinjw.servlet.web.frontcontroller.jewoo.controller;

import shinjw.servlet.web.frontcontroller.jewoo.JewooController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormJewooController implements JewooController {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/new-form.jsp");

        dispatcher.forward(request, response);
    }
}
