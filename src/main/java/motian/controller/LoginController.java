package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.UserData;
import motian.service.LoginService;
import motian.service.UserInfoService;
import motian.service.UserService;
import motian.utils.OAWebUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 9:17
 */

@RestController
@RequestMapping(LoginController.URLMAPPING)
public class LoginController extends AbstractController {
    static final String URLMAPPING = "/oa/login";
    private static final Log LOG = LogFactory.getLog(LoginController.class);

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;


    @RequestMapping(params = "method=login", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String login(
            @RequestParam(value = "nickname") String nickname,
            @RequestParam(value = "password") String password,
            HttpServletRequest request, HttpServletResponse response) {
        LOG.debug("/oa/login   " + "nickname=" + nickname + "," +
                "password=" + password);

        Map<String, Object> map = Maps.newHashMap();

        boolean bool = loginService.login(nickname, password);
        if (bool) {
            UserData userData = userService.getUserByNickname(nickname);
            map.put("userData", userData);
            map.put("userInfoData", userInfoService.getUserInfoById(userData.getUserId()));
        }

        map.put("result", bool);

        return OAWebUtils.toJsonp(map);
    }
}
