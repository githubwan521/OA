package motian.dao.mapper;

import motian.dao.model.UserData;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 16:56
 */
public interface UserMapper {
    int insert(@Param("data") UserData data);
}
