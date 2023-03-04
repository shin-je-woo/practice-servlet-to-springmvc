package shinjw.servlet.web.frontcontroller.jewoo.controller;

import shinjw.servlet.web.frontcontroller.jewoo.JewooController;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberFormJewooController implements JewooController {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        return "new-form";
    }
}
