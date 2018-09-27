package motian.dao.manager;

import motian.dao.mapper.ScheduleMapper;
import motian.dao.model.ScheduleData;
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
public class ScheduleManager {
    @Autowired
    private ScheduleMapper mapper;

    public int insert(ScheduleData schedule) {
        ScheduleData scheduleTem = getScheduleById(schedule.getSchedule_id());
        if (StringUtils.isEmpty(scheduleTem)) {
            return mapper.insert(schedule);
        }
        return 0;
    }

    public int update(ScheduleData ScheduleData) {
        return mapper.update(ScheduleData);
    }


    public ScheduleData getScheduleById(long schedule_id) {
        return mapper.getScheduleById(schedule_id);
    }

    public List<ScheduleData> getScheduleList() {
        return mapper.getScheduleList();
    }

}