package motian.dao.manager;

import motian.dao.mapper.ConferenceRoomEquipmentMapper;
import motian.dao.model.ConferenceRoomEquipmentData;
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
public class ConferenceRoomEquipmentManager {
    @Autowired
    private ConferenceRoomEquipmentMapper mapper;

    public int insert(ConferenceRoomEquipmentData businessCardHolder) {
        ConferenceRoomEquipmentData user = getConferenceRoomEquipmentById(businessCardHolder.getCre_id());
        if (StringUtils.isEmpty(user)) {
            return mapper.insert(businessCardHolder);
        }
        return 0;
    }

    public int update(ConferenceRoomEquipmentData ConferenceRoomEquipmentData) {
        return mapper.update(ConferenceRoomEquipmentData);
    }

    public ConferenceRoomEquipmentData getConferenceRoomEquipmentById(long cre_id) {
        return mapper.getConferenceRoomEquipmentById(cre_id);
    }


    public List<ConferenceRoomEquipmentData> getConferenceRoomEquipmentList() {
        return mapper.getConferenceRoomEquipmentList();
    }

}