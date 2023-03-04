package shinjw.servlet.web.frontcontroller.jewoo;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface JewooController {
    String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException;
}
