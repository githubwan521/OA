package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.BusinessCardHolderData;
import motian.service.BusinessCardHolderService;
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
@RequestMapping(BusinessCardHolderController.URLMAPPING)
public class BusinessCardHolderController extends AbstractController {
    static final String URLMAPPING = "/oa/businessCardHolder";
    private static final Log LOG = LogFactory.getLog(BusinessCardHolderController.class);

    @Autowired
    BusinessCardHolderService businessCardHolderService;

    @RequestMapping(params = "method=addBusinessCardHolder", method = RequestMethod.POST)
    public String addBusinessCardHolder(
            @RequestParam(value = "bch_name") String bch_name,
            @RequestParam(value = "user_id") String user_id,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/businessCardHolder/addBusinessCardHolder   " + "user_id=" + user_id);

        Map<String, Object> map = Maps.newHashMap();
        BusinessCardHolderData businessCardHolderData = businessCardHolderService.addBusinessCardHolder(bch_name, user_id);
        if (StringUtils.isEmpty(businessCardHolderData)) {
            LOG.warn("fail to add businessCardHolder." + "user_id=" + user_id);
        }

        map.put("result", businessCardHolderData != null);
        map.put("businessCardHolderData", businessCardHolderData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateBusinessCardHolder", method = RequestMethod.POST)
    public String updateBusinessCardHolder(
            @RequestParam(value = "businessCardHolderId") long businessCardHolderId,
            @RequestParam(value = "user_id", required = false) String user_id,
            @RequestParam(value = "bch_name", required = false) String bch_name,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/businessCardHolder/updateBusinessCardHolder   " + "businessCardHolderId=" + businessCardHolderId + "," +
                "user_id=" + user_id);

        Map<String, Object> map = Maps.newHashMap();
        BusinessCardHolderData businessCardHolderData = businessCardHolderService.updateBusinessCardHolder(
                businessCardHolderId, user_id, bch_name);
        if (StringUtils.isEmpty(businessCardHolderData)) {
            LOG.warn("fail to update businessCardHolder." + "businessCardHolderId=" + businessCardHolderId);
        }

        map.put("result", businessCardHolderData != null);
        map.put("businessCardHolderData", businessCardHolderData);

        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getBusinessCardHolderById", method = RequestMethod.GET)
    public String getBusinessCardHolderByBusinessCardHolderId(
            @RequestParam(value = "businessCardHolderId") long businessCardHolderId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/businessCardHolder/getBusinessCardHolderById   businessCardHolderId=" + businessCardHolderId);

        Map<String, Object> map = Maps.newHashMap();
        BusinessCardHolderData businessCardHolderData = businessCardHolderService.getBusinessCardHolderById(businessCardHolderId);

        map.put("businessCardHolderData", businessCardHolderData);
        return OAWebUtils.toJsonp(map);
    }


    @RequestMapping(params = "method=getBusinessCardHolderList", method = RequestMethod.GET)
    public String getBusinessCardHolderList(
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/businessCardHolder/getBusinessCardHolderList");

        Map<String, Object> map = Maps.newHashMap();
        List<BusinessCardHolderData> businessCardHolderList = businessCardHolderService.getBusinessCardHolderList();

        map.put("businessCardHolderList", businessCardHolderList);

        return OAWebUtils.toJsonp(map);
    }

}
