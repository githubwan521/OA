package motian.dao.mapper;

import motian.dao.model.ConferenceRoomData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 9:02
 */
public interface ConferenceRoomMapper {
    int insert(@Param("data") ConferenceRoomData data);

    int update(ConferenceRoomData data);

    ConferenceRoomData getConferenceRoomById(@Param("cr_id") long cr_id);

    List<ConferenceRoomData> getConferenceRoomList();

}
