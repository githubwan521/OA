package motian.service;

import motian.dao.manager.ConferenceRoomReservationManager;
import motian.dao.model.ConferenceRoomReservationData;
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
public class ConferenceRoomReservationService {
    private static final Log LOG = LogFactory.getLog(ConferenceRoomReservationService.class);

    @Autowired
    private ConferenceRoomReservationManager ConferenceRoomReservationManager;

    @Transactional
    public ConferenceRoomReservationData addConferenceRoomReservation(String applicant_id,
                                                                      String cr_id, String cre_ids, String user_ids, String start_time, String end_time) {
        ConferenceRoomReservationData addressListData = new ConferenceRoomReservationData(
                applicant_id, cr_id, cre_ids, user_ids, start_time, end_time);
        addressListData.setCrr_id(OAServiceUtils.generateId());

        boolean res = 1 == ConferenceRoomReservationManager.insert(addressListData);

        return res ? addressListData : null;
    }

    @Transactional
    public ConferenceRoomReservationData updateConferenceRoomReservation(long crr_id, String applicant_id,
                                                                         String cr_id, String cre_ids, String user_ids, String start_time, String end_time) {
        ConferenceRoomReservationData ConferenceRoomReservationData = getConferenceRoomReservationById(crr_id);


        if (!StringUtils.isEmpty(applicant_id)) {
            ConferenceRoomReservationData.setApplicant_id(applicant_id);
        }
        if (!StringUtils.isEmpty(cr_id)) {
            ConferenceRoomReservationData.setCr_id(cr_id);
        }

        if (!StringUtils.isEmpty(cre_ids)) {
            ConferenceRoomReservationData.setCre_ids(cre_ids);
        }
        if (!StringUtils.isEmpty(user_ids)) {
            ConferenceRoomReservationData.setUser_ids(user_ids);
        }
        if (!StringUtils.isEmpty(start_time)) {
            ConferenceRoomReservationData.setStart_time(start_time);
        }
        if (!StringUtils.isEmpty(end_time)) {
            ConferenceRoomReservationData.setEnd_time(end_time);
        }

        boolean res = 1 == ConferenceRoomReservationManager.update(ConferenceRoomReservationData);
        return res ? ConferenceRoomReservationData : null;
    }

    public ConferenceRoomReservationData getConferenceRoomReservationById(long bch_id) {
        return ConferenceRoomReservationManager.getConferenceRoomReservationById(bch_id);
    }

    public List<ConferenceRoomReservationData> getConferenceRoomReservationList() {
        return ConferenceRoomReservationManager.getConferenceRoomReservationList();
    }
}
