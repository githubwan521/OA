package motian.dao.manager;

import motian.dao.mapper.UserMapper;
import motian.dao.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 16:54
 */

@Repository
public class UserManager {
    @Autowired
    private UserMapper mapper;

    public int insert(UserData userData) {
        UserData user = getUserByNickname(userData.getNickname());
        if (StringUtils.isEmpty(user)) {
            return mapper.insert(userData);
        }
        return 0;
    }

    public int update(UserData userData) {
        return mapper.update(userData);
    }

    public UserData getUserByUserId(long userId) {
        return mapper.getUserByUserId(userId);
    }

    public UserData getUserByNickname(String nickname) {
        return mapper.getUserByNickname(nickname);
    }

    public List<UserData> getUserList() {
        return mapper.getUserList();
    }

    public List<UserData> getUserListByStatus(int code) {
        return mapper.getUserListByStatus(code);

    }
}
