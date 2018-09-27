package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.manager.BbsManager;
import motian.dao.model.BbsData;
import motian.utils.OAServiceUtils;
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
@RequestMapping(BbsController.URLMAPPING)
public class BbsController extends AbstractController {
    static final String URLMAPPING = "/oa/addressList";
    private static final Log LOG = LogFactory.getLog(BbsController.class);

    @Autowired
    BbsManager bbsManager;

    @RequestMapping(params = "method=addBbs", method = RequestMethod.POST)
    public String addBbs(
            @RequestParam(value = "user_id") String user_id,
            @RequestParam(value = "send_id") String send_id,
            @RequestParam(value = "recv_id") String recv_id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "status") String status,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/addressList/addBbs   " + "user_id=" + user_id);

        BbsData bbsData = new BbsData(OAServiceUtils.generateId(), user_id, send_id, recv_id, title, content, status);
        Map<String, Object> map = Maps.newHashMap();
        int result = bbsManager.insert(bbsData);

        map.put("result", result == 1);
        map.put("addressListData", bbsData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateBbs", method = RequestMethod.POST)
    public String updateBbs(
            @RequestParam(value = "bbs_id") long bbs_id,
            @RequestParam(value = "user_id") String user_id,
            @RequestParam(value = "send_id") String send_id,
            @RequestParam(value = "recv_id") String recv_id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "status") String status,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/addressList/updateBbs   " + "bbs_id=" + bbs_id + "," +
                "user_id=" + user_id);
        BbsData bbsData = bbsManager.getBbsById(bbs_id);

        if (!StringUtils.isEmpty(user_id)) {
            bbsData.setUser_id(user_id);
        }
        if (!StringUtils.isEmpty(send_id)) {
            bbsData.setSend_id(send_id);
        }
        if (!StringUtils.isEmpty(recv_id)) {
            bbsData.setRecv_id(recv_id);
        }
        if (!StringUtils.isEmpty(title)) {
            bbsData.setTitle(title);
        }
        if (!StringUtils.isEmpty(content)) {
            bbsData.setContent(content);
        }
        if (!StringUtils.isEmpty(status)) {
            bbsData.setStatus(status);
        }


        Map<String, Object> map = Maps.newHashMap();
        int result = bbsManager.update(bbsData);

        map.put("result", result == 1);

        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getBbsById", method = RequestMethod.GET)
    public String getBbsByBbsId(
            @RequestParam(value = "addressListId") long addressListId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/addressList/getBbsById   addressListId=" + addressListId);

        Map<String, Object> map = Maps.newHashMap();
        BbsData addressListData = bbsManager.getBbsById(addressListId);

        map.put("addressListData", addressListData);
        return OAWebUtils.toJsonp(map);
    }


    @RequestMapping(params = "method=getBbsList", method = RequestMethod.GET)
    public String getBbsList(
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/addressList/getBbsList");

        Map<String, Object> map = Maps.newHashMap();
        List<BbsData> addressListList = bbsManager.getBbsList();

        map.put("addressListList", addressListList);

        return OAWebUtils.toJsonp(map);
    }

}
