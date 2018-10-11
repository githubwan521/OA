package motian.service;

import motian.controller.UserController;
import motian.dao.manager.UserInfoManager;
import motian.dao.manager.UserManager;
import motian.dao.model.DataType;
import motian.dao.model.UserData;
import motian.dao.model.UserInfoData;
import motian.utils.OAServiceUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import static motian.constant.OAConstant.DEFAULTPASS;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 21:28
 */

@Service
public class UserService {
    private static final Log LOG = LogFactory.getLog(UserController.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserInfoManager userInfoManager;


    @Transactional
    public UserData addUser(String nickname, int status, int department) {
        UserData userData = new UserData(nickname, status, department);
        userData.setState(DataType.UserType.IN_SERVICE.getCode());
        userData.setUserId(OAServiceUtils.generateId());

        boolean res = 1 == userManager.insert(userData);
        if (res) {
            UserInfoData userInfoData = new UserInfoData();
            userInfoData.setUserId(getUserByNickname(nickname).getUserId());
            userInfoData.setPass(DEFAULTPASS);
            userInfoData.setIntroduce("");
            userInfoData.setInterest("");
            userInfoData.setTelephone("");
            if (1 == userInfoManager.insert(userInfoData)) {
                return userData;
            }
        }
        return null;
    }

    @Transactional
    public UserData updateUser(long userId, String nickname, int status, int department,int state) {
        UserData userData = getUserByUserId(userId);

        if (!StringUtils.isEmpty(nickname)) {
            userData.setNickname(nickname);
        }
        if (!StringUtils.isEmpty(status)) {
            userData.setStatus(status);
        }
        if (!StringUtils.isEmpty(department)) {
            userData.setDepartment(department);
        }
        if (!StringUtils.isEmpty(state)) {
            userData.setState(state);
        }

        boolean res = 1 == userManager.update(userData);
        return res ? userData : null;
    }


    @Transactional
    public boolean deleteUser(long userId) {
        UserData userData = getUserByUserId(userId);
        if (userData.getStatus() == DataType.UserType.DIMISSION.getCode()) {
            LOG.warn("fail to delete user. Users have left. userId=" + userId);
        }
        userData.setStatus(DataType.UserType.DIMISSION.getCode());

        return 1 == userManager.update(userData);
    }

    public UserData getUserByUserId(long userId) {
        return userManager.getUserByUserId(userId);
    }

    public UserData getUserByNickname(String nickname) {
        return userManager.getUserByNickname(nickname);
    }

    public List<UserData> getUserList(int model) {
        if (DataType.UserType.ALL.getCode() == model) {
            return userManager.getUserList();
        }
        return userManager.getUserListByStatus(model);
    }
}
