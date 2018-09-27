package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.BusinessCardData;
import motian.service.BusinessCardService;
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
@RequestMapping(BusinessCardController.URLMAPPING)
public class BusinessCardController extends AbstractController {
    static final String URLMAPPING = "/oa/businessCard";
    private static final Log LOG = LogFactory.getLog(BusinessCardController.class);

    @Autowired
    BusinessCardService businessCardService;

    @RequestMapping(params = "method=addBusinessCard", method = RequestMethod.POST)
    public String addBusinessCard(
            @RequestParam(value = "bch_id") String bch_id,
            @RequestParam(value = "owner_id") String owner_id,
            @RequestParam(value = "memoname") String memoname,
            @RequestParam(value = "friend_id") String friend_id,
            @RequestParam(value = "attribute") String attribute,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/businessCard/addBusinessCard   " + "bch_id=" + bch_id);

        Map<String, Object> map = Maps.newHashMap();
        BusinessCardData businessCardData = businessCardService.addBusinessCard(
                bch_id, owner_id, memoname, friend_id, attribute);
        if (StringUtils.isEmpty(businessCardData)) {
            LOG.warn("fail to add businessCard." + "bch_id=" + bch_id);
        }

        map.put("result", businessCardData != null);
        map.put("businessCardData", businessCardData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateBusinessCard", method = RequestMethod.POST)
    public String updateBusinessCard(
            @RequestParam(value = "card_id") long card_id,
            @RequestParam(value = "bch_id") String bch_id,
            @RequestParam(value = "owner_id") String owner_id,
            @RequestParam(value = "memoname") String memoname,
            @RequestParam(value = "friend_id") String friend_id,
            @RequestParam(value = "attribute") String attribute,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/businessCard/updateBusinessCard   " + "card_id=" + card_id + "," +
                "bch_id=" + bch_id);

        Map<String, Object> map = Maps.newHashMap();
        BusinessCardData businessCardData = businessCardService.updateBusinessCard(
                card_id, bch_id, owner_id, memoname, friend_id, attribute);
        if (StringUtils.isEmpty(businessCardData)) {
            LOG.warn("fail to update businessCard." + "card_id=" + card_id);
        }

        map.put("result", businessCardData != null);
        map.put("businessCardData", businessCardData);

        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getBusinessCardById", method = RequestMethod.GET)
    public String getBusinessCardByBusinessCardId(
            @RequestParam(value = "businessCardId") long businessCardId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/businessCard/getBusinessCardById   businessCardId=" + businessCardId);

        Map<String, Object> map = Maps.newHashMap();
        BusinessCardData businessCardData = businessCardService.getBusinessCardById(businessCardId);

        map.put("businessCardData", businessCardData);
        return OAWebUtils.toJsonp(map);
    }


    @RequestMapping(params = "method=getBusinessCardList", method = RequestMethod.GET)
    public String getBusinessCardList(
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/businessCard/getBusinessCardList");

        Map<String, Object> map = Maps.newHashMap();
        List<BusinessCardData> businessCardList = businessCardService.getBusinessCardList();

        map.put("businessCardList", businessCardList);

        return OAWebUtils.toJsonp(map);
    }

}
