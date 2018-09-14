package motian.dao.mapper;

import motian.dao.model.UserData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 16:56
 */
public interface UserMapper {
    int insert(@Param("data") UserData data);

    int update(UserData data);

    UserData getUserByUserId(@Param("userId") long userId);

    UserData getUserByNickname(@Param("nickname") String nickname);

    List<UserData> getUserList();

    List<UserData> getUserListByStatus(@Param("status") int status);
}
