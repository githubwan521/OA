package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.SundryData;
import motian.service.SundryService;
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
 * @Date: 2018/9/14 16:07
 */
@RestController
@RequestMapping(motian.controller.SundryController.URLMAPPING)
public class SundryController extends AbstractController {
    static final String URLMAPPING = "/oa/sundry";
    private static final Log LOG = LogFactory.getLog(SundryController.class);

    @Autowired
    SundryService sundryService;

    @RequestMapping(params = "method=addSundry", method = RequestMethod.POST)
    public Map<String, Object> addSundry(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "value") String value,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/addSundry   " +
                "key=" + key + "," + "value=" + value);

        Map<String, Object> map = Maps.newHashMap();
        SundryData sundryData = sundryService.addSundry(key, value);
        if (StringUtils.isEmpty(sundryData)) {
            LOG.warn("fail to add sundry." + "key=" + key + "," +
                    "value=" + value);
        }

        map.put("result", sundryData != null);
        map.put("sundryData", sundryData);
        return OAWebUtils.toJsonObject(map);
    }

    @RequestMapping(params = "method=updateSundry", method = RequestMethod.POST)
    public Map<String, Object> updateSundry(
            @RequestParam(value = "sundryId") long sundryId,
            @RequestParam(value = "key") String key,
            @RequestParam(value = "value") String value,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/updateSundry   " + "sundryId=" + sundryId + "," +
                "key=" + key + "," + "value=" + value);

        Map<String, Object> map = Maps.newHashMap();
        SundryData sundryData = sundryService.updateSundry(sundryId, key, value);
        if (StringUtils.isEmpty(sundryData)) {
            LOG.warn("fail to update user." + "sundryId=" + sundryId +
                    "key=" + key + ",value=" + value);
        }

        map.put("result", sundryData != null);
        map.put("sundryData", sundryData);

        return OAWebUtils.toJsonObject(map);
    }


    @RequestMapping(params = "method=getSundry", method = RequestMethod.GET)
    public Map<String, Object> getSundry(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "value") String value,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/getSundryBySundryId   key=" + key + ",value=" + value);

        Map<String, Object> map = Maps.newHashMap();
        SundryData sundryData = sundryService.getSundry(key, value);

        map.put("sundryData", sundryData);
        return OAWebUtils.toJsonObject(map);
    }

    @RequestMapping(params = "method=getSundryById", method = RequestMethod.GET)
    public Map<String, Object> getSundryById(
            @RequestParam(value = "sundryId") long sundryId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/getSundryByNickname   sundryId=" + sundryId);

        Map<String, Object> map = Maps.newHashMap();
        SundryData sundryData = sundryService.getSundryById(sundryId);

        map.put("sundryData", sundryData);
        return OAWebUtils.toJsonObject(map);
    }

    @RequestMapping(params = "method=getSundryList", method = RequestMethod.GET)
    public Map<String, Object> getSundryList(
            @RequestParam(value = "key") String key,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/user/getSundryList   key" + key);

        Map<String, Object> map = Maps.newHashMap();
        List<SundryData> sundryList = sundryService.getSundryList(key);

        map.put("sundryList", sundryList);

        return OAWebUtils.toJsonObject(map);
    }

}
