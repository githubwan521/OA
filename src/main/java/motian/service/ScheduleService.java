package motian.service;

import motian.dao.manager.ScheduleManager;
import motian.dao.model.ScheduleData;
import motian.utils.OAServiceUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 21:28
 */

@Service
public class ScheduleService {
    private static final Log LOG = LogFactory.getLog(ScheduleService.class);

    @Autowired
    private ScheduleManager ScheduleManager;

    @Transactional
    public ScheduleData addSchedule(String user_id, String readers_id, String assign_id,
                                    String title, String content, String start_time, String end_time) {
        ScheduleData addressListData = new ScheduleData(user_id, readers_id, assign_id,
                title, content, start_time, end_time);
        addressListData.setSchedule_id(OAServiceUtils.generateId());

        boolean res = 1 == ScheduleManager.insert(addressListData);

        return res ? addressListData : null;
    }

    @Transactional
    public ScheduleData updateSchedule(long schedule_id, String user_id, String readers_id, String assign_id,
                                       String title, String content, String start_time, String end_time) {
        ScheduleData ScheduleData = getScheduleById(schedule_id);


        if (!StringUtils.isEmpty(user_id)) {
            ScheduleData.setUser_id(user_id);
        }
        if (!StringUtils.isEmpty(readers_id)) {
            ScheduleData.setReaders_id(readers_id);
        }
        if (!StringUtils.isEmpty(assign_id)) {
            ScheduleData.setAssign_id(assign_id);
        }
        if (!StringUtils.isEmpty(title)) {
            ScheduleData.setTitle(title);
        }

        if (!StringUtils.isEmpty(content)) {
            ScheduleData.setContent(content);
        }

        if (!StringUtils.isEmpty(start_time)) {
            ScheduleData.setStart_time(start_time);
        }

        if (!StringUtils.isEmpty(end_time)) {
            ScheduleData.setEnd_time(end_time);
        }


        boolean res = 1 == ScheduleManager.update(ScheduleData);
        return res ? ScheduleData : null;
    }

    public ScheduleData getScheduleById(long bch_id) {
        return ScheduleManager.getScheduleById(bch_id);
    }

    public List<ScheduleData> getScheduleList() {
        return ScheduleManager.getScheduleList();
    }
}
