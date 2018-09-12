package motian.controller;

import motian.constant.OAConstant;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 22:19
 */


public abstract class AbstractController {
    private static final String OBJECT_USER_ATTRIBUTE = "OBJECT_USER";
    private static final String X_USER_ID = "userId";

    @ModelAttribute(OBJECT_USER_ATTRIBUTE)
    protected String getObjectUser(HttpServletRequest request) {
        return request.getParameter(X_USER_ID);
    }

    /**
     * @param request HTTP request
     * @param action  action name
     */
    void setActionType(HttpServletRequest request, String action) {
        request.setAttribute(OAConstant.ACTION, action);
    }
}
