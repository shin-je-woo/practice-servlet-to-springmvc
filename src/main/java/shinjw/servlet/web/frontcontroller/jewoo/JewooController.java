package shinjw.servlet.web.frontcontroller.jewoo;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface JewooController {
    JewooModelView process(Map<String, String> paramMap) throws ServletException, IOException;
}
