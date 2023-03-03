package shinjw.servlet.web.frontcontroller.jewoo;

import shinjw.servlet.web.frontcontroller.jewoo.controller.MemberFormJewooController;
import shinjw.servlet.web.frontcontroller.jewoo.controller.MemberListJewooController;
import shinjw.servlet.web.frontcontroller.jewoo.controller.MemberSaveJewooController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletJewoo", urlPatterns = "/front-controller/jewoo/*")
public class FrontControllerJewooServlet extends HttpServlet {

    private final Map<String, JewooController> controllerMap = new HashMap<>();

    public FrontControllerJewooServlet() {
        controllerMap.put("/front-controller/jewoo/members/new-form", new MemberFormJewooController());
        controllerMap.put("/front-controller/jewoo/members/save", new MemberSaveJewooController());
        controllerMap.put("/front-controller/jewoo/members", new MemberListJewooController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        JewooController controller = controllerMap.get(requestURI);
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(request, response);
    }
}
