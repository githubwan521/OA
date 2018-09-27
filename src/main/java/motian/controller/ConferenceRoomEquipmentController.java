package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.ConferenceRoomEquipmentData;
import motian.service.ConferenceRoomEquipmentService;
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
@RequestMapping(ConferenceRoomEquipmentController.URLMAPPING)
public class ConferenceRoomEquipmentController extends AbstractController {
    static final String URLMAPPING = "/oa/ConferenceRoomEquipment";
    private static final Log LOG = LogFactory.getLog(ConferenceRoomEquipmentController.class);

    @Autowired
    ConferenceRoomEquipmentService ConferenceRoomEquipmentService;

    @RequestMapping(params = "method=addConferenceRoomEquipment", method = RequestMethod.POST)
    public String addConferenceRoomEquipment(
            @RequestParam(value = "cre_name") String cre_name,
            @RequestParam(value = "cre_info") String cre_info,
            @RequestParam(value = "cre_status") String cre_status,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoomEquipment/addConferenceRoomEquipment   " + "cre_name=" + cre_name);

        Map<String, Object> map = Maps.newHashMap();
        ConferenceRoomEquipmentData ConferenceRoomEquipmentData = ConferenceRoomEquipmentService.
                addConferenceRoomEquipment(cre_name, cre_info, cre_status);
        if (StringUtils.isEmpty(ConferenceRoomEquipmentData)) {
            LOG.warn("fail to add ConferenceRoomEquipment." + "cre_name=" + cre_name);
        }

        map.put("result", ConferenceRoomEquipmentData != null);
        map.put("ConferenceRoomEquipmentData", ConferenceRoomEquipmentData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateConferenceRoomEquipment", method = RequestMethod.POST)
    public String updateConferenceRoomEquipment(
            @RequestParam(value = "cre_id") long cre_id,
            @RequestParam(value = "cre_name") String cre_name,
            @RequestParam(value = "cre_info") String cre_info,
            @RequestParam(value = "cre_status") String cre_status,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoomEquipment/updateConferenceRoomEquipment   " +
                "cre_id=" + cre_id + "," +
                "cre_name=" + cre_name);

        Map<String, Object> map = Maps.newHashMap();
        ConferenceRoomEquipmentData ConferenceRoomEquipmentData = ConferenceRoomEquipmentService.updateConferenceRoomEquipment(
                cre_id, cre_name, cre_info, cre_status);
        if (StringUtils.isEmpty(ConferenceRoomEquipmentData)) {
            LOG.warn("fail to update ConferenceRoomEquipment." + "cre_id=" + cre_id);
        }

        map.put("result", ConferenceRoomEquipmentData != null);
        map.put("ConferenceRoomEquipmentData", ConferenceRoomEquipmentData);

        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getConferenceRoomEquipmentById", method = RequestMethod.GET)
    public String getConferenceRoomEquipmentByConferenceRoomEquipmentId(
            @RequestParam(value = "ConferenceRoomEquipmentId") long ConferenceRoomEquipmentId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoomEquipment/getConferenceRoomEquipmentById   ConferenceRoomEquipmentId=" + ConferenceRoomEquipmentId);

        Map<String, Object> map = Maps.newHashMap();
        ConferenceRoomEquipmentData ConferenceRoomEquipmentData = ConferenceRoomEquipmentService.getConferenceRoomEquipmentById(ConferenceRoomEquipmentId);

        map.put("ConferenceRoomEquipmentData", ConferenceRoomEquipmentData);
        return OAWebUtils.toJsonp(map);
    }


    @RequestMapping(params = "method=getConferenceRoomEquipmentList", method = RequestMethod.GET)
    public String getConferenceRoomEquipmentList(
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoomEquipment/getConferenceRoomEquipmentList");

        Map<String, Object> map = Maps.newHashMap();
        List<ConferenceRoomEquipmentData> ConferenceRoomEquipmentList = ConferenceRoomEquipmentService.getConferenceRoomEquipmentList();

        map.put("ConferenceRoomEquipmentList", ConferenceRoomEquipmentList);

        return OAWebUtils.toJsonp(map);
    }

}
