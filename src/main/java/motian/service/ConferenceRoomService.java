package motian.service;

import motian.dao.manager.ConferenceRoomManager;
import motian.dao.model.ConferenceRoomData;
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
public class ConferenceRoomService {
    private static final Log LOG = LogFactory.getLog(ConferenceRoomService.class);

    @Autowired
    private ConferenceRoomManager ConferenceRoomManager;

    @Transactional
    public ConferenceRoomData addConferenceRoom(String cr_name, String cr_status) {
        ConferenceRoomData addressListData = new ConferenceRoomData(cr_name, cr_status);
        addressListData.setCr_id(OAServiceUtils.generateId());

        boolean res = 1 == ConferenceRoomManager.insert(addressListData);

        return res ? addressListData : null;
    }

    @Transactional
    public ConferenceRoomData updateConferenceRoom(long cr_id, String cr_name, String cr_status) {
        ConferenceRoomData ConferenceRoomData = getConferenceRoomById(cr_id);


        if (!StringUtils.isEmpty(cr_name)) {
            ConferenceRoomData.setCr_name(cr_name);
        }
        if (!StringUtils.isEmpty(cr_status)) {
            ConferenceRoomData.setCr_status(cr_status);
        }

        boolean res = 1 == ConferenceRoomManager.update(ConferenceRoomData);
        return res ? ConferenceRoomData : null;
    }

    public ConferenceRoomData getConferenceRoomById(long bch_id) {
        return ConferenceRoomManager.getConferenceRoomById(bch_id);
    }

    public List<ConferenceRoomData> getConferenceRoomList() {
        return ConferenceRoomManager.getConferenceRoomList();
    }
}
