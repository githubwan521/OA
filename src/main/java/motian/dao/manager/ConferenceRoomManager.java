package motian.dao.manager;

import motian.dao.mapper.ConferenceRoomMapper;
import motian.dao.model.ConferenceRoomData;
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
public class ConferenceRoomManager {
    @Autowired
    private ConferenceRoomMapper mapper;

    public int insert(ConferenceRoomData businessCardHolder) {
        ConferenceRoomData user = getConferenceRoomById(businessCardHolder.getCr_id());
        if (StringUtils.isEmpty(user)) {
            return mapper.insert(businessCardHolder);
        }
        return 0;
    }

    public int update(ConferenceRoomData ConferenceRoomData) {
        return mapper.update(ConferenceRoomData);
    }

    public ConferenceRoomData getConferenceRoomById(long cr_id) {
        return mapper.getConferenceRoomById(cr_id);
    }


    public List<ConferenceRoomData> getConferenceRoomList() {
        return mapper.getConferenceRoomList();
    }

}