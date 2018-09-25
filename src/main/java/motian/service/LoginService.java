package motian.service;

import motian.controller.UserController;
import motian.dao.manager.UserInfoManager;
import motian.dao.manager.UserManager;
import motian.dao.model.UserData;
import motian.dao.model.UserInfoData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 14:20
 */

@Service
public class LoginService {
    private static final Log LOG = LogFactory.getLog(UserController.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserInfoManager userInfoManager;

    public boolean login(String nickname, String password) {
        LOG.info("nickname=" + nickname + "password=" + password);
        UserData userData = userManager.getUserByNickname(nickname);
        if (StringUtils.isEmpty(userData)) {
            return false;
        }
        LOG.info("1111  nickname=" + nickname + "password=" + password);

        UserInfoData userInfoData = userInfoManager.getUserInfoById(userData.getUserId());
        LOG.info(userInfoData);
        return password.equals(userInfoData.getPass());
    }
}
