package motian.service;

import motian.dao.manager.ConferenceRoomEquipmentManager;
import motian.dao.model.ConferenceRoomEquipmentData;
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
public class ConferenceRoomEquipmentService {
    private static final Log LOG = LogFactory.getLog(ConferenceRoomEquipmentService.class);

    @Autowired
    private ConferenceRoomEquipmentManager ConferenceRoomEquipmentManager;

    @Transactional
    public ConferenceRoomEquipmentData addConferenceRoomEquipment(String cre_name,
                                                                  String cre_status, String cre_info) {
        ConferenceRoomEquipmentData conferenceRoomEquipmentData = new ConferenceRoomEquipmentData(cre_name, cre_info, cre_status);
        conferenceRoomEquipmentData.setCre_id(OAServiceUtils.generateId());

        boolean res = 1 == ConferenceRoomEquipmentManager.insert(conferenceRoomEquipmentData);

        return res ? conferenceRoomEquipmentData : null;
    }

    @Transactional
    public ConferenceRoomEquipmentData updateConferenceRoomEquipment(long cre_id, String cre_name, String cre_info, String cre_status) {
        ConferenceRoomEquipmentData ConferenceRoomEquipmentData = getConferenceRoomEquipmentById(cre_id);


        if (!StringUtils.isEmpty(cre_name)) {
            ConferenceRoomEquipmentData.setCre_name(cre_name);
        }
        if (!StringUtils.isEmpty(cre_info)) {
            ConferenceRoomEquipmentData.setCre_info(cre_info);
        }
        if (!StringUtils.isEmpty(cre_status)) {
            ConferenceRoomEquipmentData.setCre_status(cre_status);
        }
        boolean res = 1 == ConferenceRoomEquipmentManager.update(ConferenceRoomEquipmentData);
        return res ? ConferenceRoomEquipmentData : null;
    }

    public ConferenceRoomEquipmentData getConferenceRoomEquipmentById(long bch_id) {
        return ConferenceRoomEquipmentManager.getConferenceRoomEquipmentById(bch_id);
    }

    public List<ConferenceRoomEquipmentData> getConferenceRoomEquipmentList() {
        return ConferenceRoomEquipmentManager.getConferenceRoomEquipmentList();
    }
}
