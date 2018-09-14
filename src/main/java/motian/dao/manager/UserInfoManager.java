package motian.dao.manager;

import motian.dao.mapper.UserInfoMapper;
import motian.dao.model.UserInfoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 11:24
 */
@Repository
public class UserInfoManager {
    @Autowired
    private UserInfoMapper mapper;

    public int insert(UserInfoData userInfoData) {
        UserInfoData user = getUserInfoById(userInfoData.getUserId());
        if (StringUtils.isEmpty(user)) {
            return mapper.insert(userInfoData);
        }
        return 0;
    }

    public int update(UserInfoData userInfoData) {
        return mapper.update(userInfoData);
    }

    public UserInfoData getUserInfoById(long userId) {
        return mapper.getUserInfoById(userId);
    }


    public List<UserInfoData> getUserInfoList(int share) {
        return mapper.getUserInfoList(share);
    }

}