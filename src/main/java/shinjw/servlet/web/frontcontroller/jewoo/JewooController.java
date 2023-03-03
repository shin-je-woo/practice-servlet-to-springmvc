package shinjw.servlet.web.frontcontroller.jewoo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface JewooController {
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
