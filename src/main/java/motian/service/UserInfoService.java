package motian.service;

import motian.controller.UserController;
import motian.dao.manager.UserInfoManager;
import motian.dao.manager.UserManager;
import motian.dao.model.DataType;
import motian.dao.model.UserData;
import motian.dao.model.UserInfoData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 11:34
 */

@Service
public class UserInfoService {
    private static final Log LOG = LogFactory.getLog(UserController.class);


    @Autowired
    private UserManager userManager;

    @Autowired
    private UserInfoManager userInfoManager;

    @Transactional
    public UserInfoData addUserInfo(long userId, String pass, String introduce,
                                    String interest, String telephone, int share) {
        UserData userData = userManager.getUserByUserId(userId);
        if (StringUtils.isEmpty(userData)) {
            LOG.warn("fail to addUserInfo userinfo. user does not exist. userId=" + userId);
            return null;
        }
        UserInfoData userInfoData = new UserInfoData(userId, pass, introduce, interest, telephone, share);

        boolean res = 1 == userInfoManager.insert(userInfoData);
        return res ? userInfoData : null;
    }

    @Transactional
    public UserInfoData updateUserInfo(long userId, String pass, String introduce,
                                       String interest, String telephone, int share) {
        UserData userData = userManager.getUserByUserId(userId);
        if (StringUtils.isEmpty(userData)) {
            LOG.warn("fail to updateUserInfo userinfo. user does not exist. userId=" + userId);
            return null;
        }
        UserInfoData userInfoData = userInfoManager.getUserInfoById(userId);

        if (!StringUtils.isEmpty(pass)) {
            userInfoData.setPass(pass);
        }
        if (!StringUtils.isEmpty(introduce)) {
            userInfoData.setIntroduce(introduce);
        }
        if (!StringUtils.isEmpty(interest)) {
            userInfoData.setInterest(interest);
        }
        if (!StringUtils.isEmpty(telephone)) {
            userInfoData.setTelephone(telephone);
        }
        if (!StringUtils.isEmpty(share)) {
            userInfoData.setShare(share);
        }
        boolean res = 1 == userInfoManager.update(userInfoData);
        return res ? userInfoData : null;
    }


    public UserInfoData getUserInfoById(long userId) {
        return userInfoManager.getUserInfoById(userId);
    }


    public List<UserInfoData> getUserInfoList(int model) {
        return userInfoManager.getUserInfoList(model);
    }
}
