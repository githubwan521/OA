package motian.service;

import motian.dao.manager.UserManager;
import motian.dao.model.UserData;
import motian.utils.OAServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 21:28
 */

@Service
public class UserService {

    @Autowired
    private UserManager userManager;

    @Transactional
    public UserData addUser(String nickname, int identity, int department) {
        UserData userData = new UserData(nickname, identity, department);
        userData.setUserId(OAServiceUtils.generateId());

        boolean res = 1 == userManager.insert(userData);
        return res ? userData : null;
    }


}
