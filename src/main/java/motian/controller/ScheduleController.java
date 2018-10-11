package motian.controller;

import com.google.common.collect.Maps;
import lombok.extern.apachecommons.CommonsLog;
import motian.dao.model.ScheduleData;
import motian.service.ScheduleService;
import motian.utils.OAWebUtils;
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
@RequestMapping(ScheduleController.URLMAPPING)
@CommonsLog
public class ScheduleController extends AbstractController {
    static final String URLMAPPING = "/oa/Schedule";

    @Autowired
    ScheduleService ScheduleService;

    @RequestMapping(params = "method=addSchedule", method = RequestMethod.POST)
    public String addSchedule(
            @RequestParam(value = "user_id") String user_id,
            @RequestParam(value = "readers_id") String readers_id,
            @RequestParam(value = "assign_id") String assign_id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "start_time") String start_time,
            @RequestParam(value = "coend_timentent") String end_time,
            HttpServletRequest request, HttpServletResponse response) {

        log.debug("/oa/Schedule/addSchedule   " + "user_id=" + user_id);

        Map<String, Object> map = Maps.newHashMap();
        ScheduleData ScheduleData = ScheduleService.
                addSchedule(user_id, readers_id, assign_id,
                        title, content, start_time, end_time);
        if (StringUtils.isEmpty(ScheduleData)) {
            log.warn("fail to add Schedule." + "user_id=" + user_id);
        }

        map.put("result", ScheduleData != null);
        map.put("ScheduleData", ScheduleData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateSchedule", method = RequestMethod.POST)
    public String updateSchedule(
            @RequestParam(value = "schedule_id") long schedule_id,
            @RequestParam(value = "user_id") String user_id,
            @RequestParam(value = "readers_id") String readers_id,
            @RequestParam(value = "assign_id") String assign_id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "start_time") String start_time,
            @RequestParam(value = "coend_timentent") String end_time,
            HttpServletRequest request, HttpServletResponse response) {

        log.debug("/oa/Schedule/updateSchedule   " +
                "schedule_id=" + schedule_id);

        Map<String, Object> map = Maps.newHashMap();
        ScheduleData ScheduleData = ScheduleService.updateSchedule(schedule_id, user_id, readers_id, assign_id,
                title, content, start_time, end_time);
        if (StringUtils.isEmpty(ScheduleData)) {
            log.warn("fail to update Schedule." + "schedule_id=" + schedule_id);
        }

        map.put("result", ScheduleData != null);
        map.put("ScheduleData", ScheduleData);

        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getScheduleById", method = RequestMethod.GET)
    public String getScheduleByScheduleId(
            @RequestParam(value = "ScheduleId") long ScheduleId,
            HttpServletRequest request, HttpServletResponse response) {

        log.debug("/oa/Schedule/getScheduleById   ScheduleId=" + ScheduleId);

        Map<String, Object> map = Maps.newHashMap();
        ScheduleData ScheduleData = ScheduleService.getScheduleById(ScheduleId);

        map.put("ScheduleData", ScheduleData);
        return OAWebUtils.toJsonp(map);
    }


    @RequestMapping(params = "method=getScheduleList", method = RequestMethod.GET)
    public String getScheduleList(
            HttpServletRequest request, HttpServletResponse response) {

        log.debug("/oa/Schedule/getScheduleList");

        Map<String, Object> map = Maps.newHashMap();
        List<ScheduleData> ScheduleList = ScheduleService.getScheduleList();

        map.put("ScheduleList", ScheduleList);

        return OAWebUtils.toJsonp(map);
    }

}
