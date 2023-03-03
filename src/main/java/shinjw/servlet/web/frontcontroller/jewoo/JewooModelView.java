package shinjw.servlet.web.frontcontroller.jewoo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class JewooModelView {

    private final String viewName;
    private final Map<String, Object> model = new HashMap<>();

    public JewooModelView(String viewName) {
        this.viewName = viewName;
    }
}
