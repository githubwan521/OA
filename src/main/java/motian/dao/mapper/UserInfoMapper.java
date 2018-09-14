package motian.dao.mapper;

import motian.dao.model.UserInfoData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 11:13
 */
public interface UserInfoMapper {

    int insert(@Param("data") UserInfoData data);

    int update(UserInfoData data);

    UserInfoData getUserInfoById(@Param("userId") long userId);

    List<UserInfoData> getUserInfoList(@Param("share") int share);
}
