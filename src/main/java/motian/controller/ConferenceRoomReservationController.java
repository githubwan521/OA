package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.ConferenceRoomReservationData;
import motian.service.ConferenceRoomReservationService;
import motian.utils.OAWebUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 21:56
 */

@RestController
@RequestMapping(ConferenceRoomReservationController.URLMAPPING)
public class ConferenceRoomReservationController extends AbstractController {
    static final String URLMAPPING = "/oa/ConferenceRoomReservation";
    private static final Log LOG = LogFactory.getLog(ConferenceRoomReservationController.class);

    @Autowired
    ConferenceRoomReservationService ConferenceRoomReservationService;

    @RequestMapping(params = "method=addConferenceRoomReservation", method = RequestMethod.POST)
    public String addConferenceRoomReservation(
            @RequestParam(value = "applicant_id") String applicant_id,
            @RequestParam(value = "cr_id") String cr_id,
            @RequestParam(value = "cre_ids") String cre_ids,
            @RequestParam(value = "user_ids") String user_ids,
            @RequestParam(value = "start_time") String start_time,
            @RequestParam(value = "end_time") String end_time,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoomReservation/addConferenceRoomReservation   " + "applicant_id=" + applicant_id);

        Map<String, Object> map = Maps.newHashMap();
        ConferenceRoomReservationData ConferenceRoomReservationData = ConferenceRoomReservationService.
                addConferenceRoomReservation(applicant_id, cr_id, cre_ids, user_ids, start_time, end_time);
        if (StringUtils.isEmpty(ConferenceRoomReservationData)) {
            LOG.warn("fail to add ConferenceRoomReservation." + "applicant_id=" + applicant_id);
        }

        map.put("result", ConferenceRoomReservationData != null);
        map.put("ConferenceRoomReservationData", ConferenceRoomReservationData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateConferenceRoomReservation", method = RequestMethod.POST)
    public String updateConferenceRoomReservation(
            @RequestParam(value = "crr_id") long crr_id,
            @RequestParam(value = "applicant_id") String applicant_id,
            @RequestParam(value = "cr_id") String cr_id,
            @RequestParam(value = "cre_ids") String cre_ids,
            @RequestParam(value = "user_ids") String user_ids,
            @RequestParam(value = "start_time") String start_time,
            @RequestParam(value = "end_time") String end_time,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoomReservation/updateConferenceRoomReservation   " +
                "crr_id=" + crr_id);

        Map<String, Object> map = Maps.newHashMap();
        ConferenceRoomReservationData ConferenceRoomReservationData = ConferenceRoomReservationService.updateConferenceRoomReservation(
                crr_id, applicant_id, cr_id, cre_ids, user_ids, start_time, end_time);
        if (StringUtils.isEmpty(ConferenceRoomReservationData)) {
            LOG.warn("fail to update ConferenceRoomReservation." + "crr_id=" + crr_id);
        }

        map.put("result", ConferenceRoomReservationData != null);
        map.put("ConferenceRoomReservationData", ConferenceRoomReservationData);

        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getConferenceRoomReservationById", method = RequestMethod.GET)
    public String getConferenceRoomReservationByConferenceRoomReservationId(
            @RequestParam(value = "ConferenceRoomReservationId") long ConferenceRoomReservationId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoomReservation/getConferenceRoomReservationById   ConferenceRoomReservationId=" + ConferenceRoomReservationId);

        Map<String, Object> map = Maps.newHashMap();
        ConferenceRoomReservationData ConferenceRoomReservationData = ConferenceRoomReservationService.getConferenceRoomReservationById(ConferenceRoomReservationId);

        map.put("ConferenceRoomReservationData", ConferenceRoomReservationData);
        return OAWebUtils.toJsonp(map);
    }


    @RequestMapping(params = "method=getConferenceRoomReservationList", method = RequestMethod.GET)
    public String getConferenceRoomReservationList(
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoomReservation/getConferenceRoomReservationList");

        Map<String, Object> map = Maps.newHashMap();
        List<ConferenceRoomReservationData> ConferenceRoomReservationList = ConferenceRoomReservationService.getConferenceRoomReservationList();

        map.put("ConferenceRoomReservationList", ConferenceRoomReservationList);

        return OAWebUtils.toJsonp(map);
    }

}
