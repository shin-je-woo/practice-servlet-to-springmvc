package shinjw.servlet.web.frontcontroller.jewoo;

import shinjw.servlet.web.frontcontroller.ModelView;
import shinjw.servlet.web.frontcontroller.jewoo.adapter.ControllerJewoo3Adapter;
import shinjw.servlet.web.frontcontroller.jewoo.adapter.ControllerJewoo4Adapter;
import shinjw.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import shinjw.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import shinjw.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import shinjw.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import shinjw.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import shinjw.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerJewooServlet", urlPatterns = "/front-controller/jewoo/*")
public class FrontControllerJewooServlet extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();

    private final List<JewooHandlerAdapter> handlerAdapterList = new ArrayList<>();

    public FrontControllerJewooServlet() {
        initHandlerMapping();
        initHandlerAdapterList();
    }

    private void initHandlerAdapterList() {
        handlerAdapterList.add(new ControllerJewoo3Adapter());
        handlerAdapterList.add(new ControllerJewoo4Adapter());
    }

    private void initHandlerMapping() {
        handlerMappingMap.put("/front-controller/jewoo/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/jewoo/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/jewoo/v3/members", new MemberListControllerV3());

        handlerMappingMap.put("/front-controller/jewoo/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/jewoo/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/jewoo/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);
        if(handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        JewooHandlerAdapter handlerAdapter = getHandlerAdapter(handler);

        ModelView modelView = handlerAdapter.handle(request, response, handler);
        String viewName = modelView.getViewName();
        JewooView view = viewResolver(viewName);

        view.render(modelView.getModel(), request, response);
    }

    private JewooHandlerAdapter getHandlerAdapter(Object handler) {
        return handlerAdapterList.stream()
                .filter(adapter -> adapter.supports(handler))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 handler입니다. handler = " + handler));
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private JewooView viewResolver(String viewName) {
        return new JewooView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
