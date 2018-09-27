package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.ConferenceRoomData;
import motian.service.ConferenceRoomService;
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
@RequestMapping(ConferenceRoomController.URLMAPPING)
public class ConferenceRoomController extends AbstractController {
    static final String URLMAPPING = "/oa/ConferenceRoom";
    private static final Log LOG = LogFactory.getLog(ConferenceRoomController.class);

    @Autowired
    ConferenceRoomService ConferenceRoomService;

    @RequestMapping(params = "method=addConferenceRoom", method = RequestMethod.POST)
    public String addConferenceRoom(
            @RequestParam(value = "cr_name") String cr_name,
            @RequestParam(value = "cr_status") String cr_status,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoom/addConferenceRoom   " + "user_id=" + cr_name);

        Map<String, Object> map = Maps.newHashMap();
        ConferenceRoomData ConferenceRoomData = ConferenceRoomService.addConferenceRoom(cr_name, cr_status);
        if (StringUtils.isEmpty(ConferenceRoomData)) {
            LOG.warn("fail to add ConferenceRoom." + "user_id=" + cr_name);
        }

        map.put("result", ConferenceRoomData != null);
        map.put("ConferenceRoomData", ConferenceRoomData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateConferenceRoom", method = RequestMethod.POST)
    public String updateConferenceRoom(
            @RequestParam(value = "cr_id") long cr_id,
            @RequestParam(value = "cr_name") String cr_name,
            @RequestParam(value = "cr_status") String cr_status,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoom/updateConferenceRoom   " + "cr_id=" + cr_id + "," +
                "cr_name=" + cr_name);

        Map<String, Object> map = Maps.newHashMap();
        ConferenceRoomData ConferenceRoomData = ConferenceRoomService.updateConferenceRoom(
                cr_id, cr_name, cr_status);
        if (StringUtils.isEmpty(ConferenceRoomData)) {
            LOG.warn("fail to update ConferenceRoom." + "cr_id=" + cr_id);
        }

        map.put("result", ConferenceRoomData != null);
        map.put("ConferenceRoomData", ConferenceRoomData);

        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getConferenceRoomById", method = RequestMethod.GET)
    public String getConferenceRoomByConferenceRoomId(
            @RequestParam(value = "ConferenceRoomId") long ConferenceRoomId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoom/getConferenceRoomById   ConferenceRoomId=" + ConferenceRoomId);

        Map<String, Object> map = Maps.newHashMap();
        ConferenceRoomData ConferenceRoomData = ConferenceRoomService.getConferenceRoomById(ConferenceRoomId);

        map.put("ConferenceRoomData", ConferenceRoomData);
        return OAWebUtils.toJsonp(map);
    }


    @RequestMapping(params = "method=getConferenceRoomList", method = RequestMethod.GET)
    public String getConferenceRoomList(
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/ConferenceRoom/getConferenceRoomList");

        Map<String, Object> map = Maps.newHashMap();
        List<ConferenceRoomData> ConferenceRoomList = ConferenceRoomService.getConferenceRoomList();

        map.put("ConferenceRoomList", ConferenceRoomList);

        return OAWebUtils.toJsonp(map);
    }

}
