package motian.dao.mapper;

import motian.dao.model.ConferenceRoomReservationData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 9:03
 */
public interface ConferenceRoomReservationMapper {
    int insert(@Param("data") ConferenceRoomReservationData data);

    int update(ConferenceRoomReservationData data);

    ConferenceRoomReservationData getConferenceRoomEquipmentById(@Param("crr_id") long crr_id);

    List<ConferenceRoomReservationData> getConferenceRoomEquipmentList();
}
