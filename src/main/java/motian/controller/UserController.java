package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.UserData;
import motian.service.UserService;
import motian.utils.OAWebUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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
            @RequestParam(value = "status") int status,
            @RequestParam(value = "department") int department,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/addUser   " + "nickname=" + nickname + "," +
                "identity=" + status + "," + "department=" + department);

        Map<String, Object> map = Maps.newHashMap();
        UserData userData = userService.addUser(nickname, status, department);
        if (StringUtils.isEmpty(userData)) {
            LOG.warn("fail to add user." + "nickname=" + nickname + "," +
                    "identity=" + status + "," + "department=" + department);
        }

        map.put("result", userData != null);
        map.put("userData", userData);
        return OAWebUtils.toJsonObject(map);
    }

    @RequestMapping(params = "method=updateUser", method = RequestMethod.POST)
    public Map<String, Object> updateUser(
            @RequestParam(value = "userId") long userId,
            @RequestParam(value = "nickname", required = false) String nickname,
            @RequestParam(value = "status", required = false) int status,
            @RequestParam(value = "department", required = false) int department,
            @RequestParam(value = "state", required = false) int state,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/updateUser   " + "nickname=" + nickname + "," +
                "identity=" + status + "," + "department=" + department);

        Map<String, Object> map = Maps.newHashMap();
        UserData userData = userService.updateUser(userId, nickname, status, department, state);
        if (StringUtils.isEmpty(userData)) {
            LOG.warn("fail to update user." + "userId=" + userId);
        }

        map.put("result", userData != null);
        map.put("userData", userData);

        return OAWebUtils.toJsonObject(map);
    }

    @RequestMapping(params = "method=deleteUser", method = RequestMethod.POST)
    public Map<String, Object> deleteUser(
            @RequestParam(value = "userId") long userId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/deleteUser   " + "userId=" + userId);

        Map<String, Object> map = Maps.newHashMap();
        boolean bool = userService.deleteUser(userId);
        if (bool) {
            LOG.warn("fail to delete user." + "userId=" + userId);
        }

        map.put("result", bool);
        return OAWebUtils.toJsonObject(map);
    }

    @RequestMapping(params = "method=getUserByUserId", method = RequestMethod.GET)
    public Map<String, Object> getUserByUserId(
            @RequestParam(value = "userId") int userId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/getUserByUserId   userId=" + userId);

        Map<String, Object> map = Maps.newHashMap();
        UserData userData = userService.getUserByUserId(userId);

        map.put("userData", userData);
        return OAWebUtils.toJsonObject(map);
    }

    @RequestMapping(params = "method=getUserByNickname", method = RequestMethod.GET)
    public Map<String, Object> getUserByNickname(
            @RequestParam(value = "nickname") String nickname,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/getUserByNickname   nickname=" + nickname);

        Map<String, Object> map = Maps.newHashMap();
        UserData userData = userService.getUserByNickname(nickname);

        map.put("userData", userData);
        return OAWebUtils.toJsonObject(map);
    }

    @RequestMapping(params = "method=getUserList", method = RequestMethod.GET)
    public Map<String, Object> getUserList(
            @RequestParam(value = "model") int model,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/getUserList   model" + model);

        Map<String, Object> map = Maps.newHashMap();
        List<UserData> userList = userService.getUserList(model);

        map.put("userList", userList);

        return OAWebUtils.toJsonObject(map);
    }

}
