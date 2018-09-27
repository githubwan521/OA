package motian.dao.mapper;

import motian.dao.model.ConferenceRoomEquipmentData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 9:01
 */
public interface ConferenceRoomEquipmentMapper {
    int insert(@Param("data") ConferenceRoomEquipmentData data);

    int update(ConferenceRoomEquipmentData data);

    ConferenceRoomEquipmentData getConferenceRoomEquipmentById(@Param("cre_id") long cre_id);

    List<ConferenceRoomEquipmentData> getConferenceRoomEquipmentList();
}
