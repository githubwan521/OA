package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.UserData;
import motian.service.UserService;
import motian.utils.OAWebUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date: 2018/9/12 21:56
 */

@RestController
@RequestMapping(UserController.URLMAPPING)
public class UserController extends AbstractController {
    static final String URLMAPPING = "/oa/user";
    private static final Log LOG = LogFactory.getLog(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(params = "method=addUser", method = RequestMethod.POST)
    public Map<String, Object> addUser(
            @RequestParam(value = "nickname") String nickname,
            @RequestParam(value = "identity") int identity,
            @RequestParam(value = "department") int department,
            HttpServletRequest request, HttpServletResponse response) {

        setActionType(request, "getExerciseProgress");

        LOG.debug("/oa/user/addUser   " +
                "nickname=" + nickname + "," +
                "identity=" + identity + "," +
                "department=" + department);

        Map<String, Object> map = Maps.newHashMap();
        UserData userData = userService.addUser(nickname, identity, department);
        map.put("userInfo", userData);

        return OAWebUtils.toJsonObject(map);
    }
}
