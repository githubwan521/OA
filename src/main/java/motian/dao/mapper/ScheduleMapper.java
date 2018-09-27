package motian.dao.mapper;

import motian.dao.model.ScheduleData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 9:05
 */
public interface ScheduleMapper {
    int insert(@Param("data") ScheduleData data);

    int update(ScheduleData data);

    ScheduleData getScheduleById(@Param("schedule_id") long schedule_id);

    List<ScheduleData> getScheduleList();
}
