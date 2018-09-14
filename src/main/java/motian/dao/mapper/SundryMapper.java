package motian.dao.mapper;

import motian.dao.model.SundryData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 15:20
 */

public interface SundryMapper {
    int insert(@Param("data") SundryData data);

    int update(SundryData data);

    SundryData getSundry(@Param("key") String key, @Param("value") String value);

    SundryData getSundryById(@Param("sundryId") long sundryId);

    List<SundryData> getSundryList(@Param("key") String key);

}
