package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.UserInfoData;
import motian.service.UserInfoService;
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
 * @Date: 2018/9/14 10:53
 */

@RestController
@RequestMapping(UserInfoController.URLMAPPING)

public class UserInfoController extends AbstractController {
    static final String URLMAPPING = "/oa/userinfo";
    private static final Log LOG = LogFactory.getLog(UserController.class);

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(params = "method=addUserInfo", method = RequestMethod.POST)
    public String addUserInfo(
            @RequestParam(value = "userId") long userId,
            @RequestParam(value = "pass", required = false) String pass,
            @RequestParam(value = "introduce", required = false) String introduce,
            @RequestParam(value = "interest", required = false) String interest,
            @RequestParam(value = "telephone", required = false) String telephone,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/addUserInfo   " + "userId=" + userId + "," +
                "pass=" + pass + "," + "introduce=" + introduce + "interest=" + interest
                + "telephone=" + telephone);

        Map<String, Object> map = Maps.newHashMap();
        UserInfoData userInfoData = userInfoService.addUserInfo(userId, pass, introduce,
                interest, telephone);
        if (StringUtils.isEmpty(userInfoData)) {
            LOG.warn("fail to add userinfo." + "userId=" + userId);
        }

        map.put("result", userInfoData != null);
        map.put("userInfoData", userInfoData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateUserInfo", method = RequestMethod.POST)
    public String updateUserInfo(
            @RequestParam(value = "userId") long userId,
            @RequestParam(value = "pass", required = false) String pass,
            @RequestParam(value = "introduce", required = false) String introduce,
            @RequestParam(value = "interest", required = false) String interest,
            @RequestParam(value = "telephone", required = false) String telephone,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/updateUserInfo   " + "userId=" + userId + "," +
                "pass=" + pass + "," + "introduce=" + introduce + "interest=" + interest
                + "telephone=" + telephone);

        Map<String, Object> map = Maps.newHashMap();
        UserInfoData userInfoData = userInfoService.updateUserInfo(userId, pass, introduce,
                interest, telephone);
        if (StringUtils.isEmpty(userInfoData)) {
            LOG.warn("fail to update user." + "userId=" + userId);
        }

        map.put("result", userInfoData != null);
        map.put("userInfoData", userInfoData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getUserInfoById", method = RequestMethod.GET)
    public String getUserInfoById(
            @RequestParam(value = "userId") long userId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/getUserInfoById");
        Map<String, Object> map = Maps.newHashMap();
        UserInfoData userInfoData = userInfoService.getUserInfoById(userId);

        map.put("userInfoData", userInfoData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getUserInfoList", method = RequestMethod.GET)
    public String getUserInfoList(
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/getUserInfoList");
        Map<String, Object> map = Maps.newHashMap();
        List<UserInfoData> userInfoList = userInfoService.getUserInfoList();

        map.put("userInfoList", userInfoList);
        return OAWebUtils.toJsonp(map);
    }
}