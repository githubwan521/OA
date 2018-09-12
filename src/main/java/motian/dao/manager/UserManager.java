package motian.dao.manager;

import motian.dao.mapper.UserMapper;
import motian.dao.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        return this.mapper.insert(userData);
    }


}
