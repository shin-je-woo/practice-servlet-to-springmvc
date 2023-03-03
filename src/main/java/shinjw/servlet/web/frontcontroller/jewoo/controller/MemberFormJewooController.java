package shinjw.servlet.web.frontcontroller.jewoo.controller;

import shinjw.servlet.web.frontcontroller.jewoo.JewooController;
import shinjw.servlet.web.frontcontroller.jewoo.JewooModelView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberFormJewooController implements JewooController {

    @Override
    public JewooModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        return new JewooModelView("new-form");
    }
}
