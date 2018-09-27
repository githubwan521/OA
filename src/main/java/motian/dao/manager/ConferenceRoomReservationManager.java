package motian.dao.manager;

import motian.dao.mapper.ConferenceRoomReservationMapper;
import motian.dao.model.ConferenceRoomReservationData;
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
public class ConferenceRoomReservationManager {
    @Autowired
    private ConferenceRoomReservationMapper mapper;

    public int insert(ConferenceRoomReservationData conferenceRoomReservation) {
        ConferenceRoomReservationData user = getConferenceRoomReservationById(conferenceRoomReservation.getCrr_id());
        if (StringUtils.isEmpty(user)) {
            return mapper.insert(conferenceRoomReservation);
        }
        return 0;
    }

    public int update(ConferenceRoomReservationData ConferenceRoomReservationData) {
        return mapper.update(ConferenceRoomReservationData);
    }

    public ConferenceRoomReservationData getConferenceRoomReservationById(long crr_id) {
        return mapper.getConferenceRoomEquipmentById(crr_id);
    }


    public List<ConferenceRoomReservationData> getConferenceRoomReservationList() {
        return mapper.getConferenceRoomEquipmentList();
    }

}