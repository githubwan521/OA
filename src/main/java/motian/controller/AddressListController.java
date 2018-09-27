package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.AddressListData;
import motian.service.AddressListService;
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
@RequestMapping(AddressListController.URLMAPPING)
public class AddressListController extends AbstractController {
    static final String URLMAPPING = "/oa/addressList";
    private static final Log LOG = LogFactory.getLog(AddressListController.class);

    @Autowired
    AddressListService addressListService;

    @RequestMapping(params = "method=addAddressList", method = RequestMethod.POST)
    public String addAddressList(
            @RequestParam(value = "user_id") long user_id,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/addressList/addAddressList   " + "user_id=" + user_id);

        Map<String, Object> map = Maps.newHashMap();
        AddressListData addressListData = addressListService.addAddressList(user_id);
        if (StringUtils.isEmpty(addressListData)) {
            LOG.warn("fail to add addressList." + "user_id=" + user_id);
        }

        map.put("result", addressListData != null);
        map.put("addressListData", addressListData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateAddressList", method = RequestMethod.POST)
    public String updateAddressList(
            @RequestParam(value = "addressListId") long addressListId,
            @RequestParam(value = "user_id", required = false) long user_id,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/addressList/updateAddressList   " + "addressListId=" + addressListId + "," +
                "user_id=" + user_id);

        Map<String, Object> map = Maps.newHashMap();
        AddressListData addressListData = addressListService.updateAddressList(addressListId, user_id);
        if (StringUtils.isEmpty(addressListData)) {
            LOG.warn("fail to update addressList." + "addressListId=" + addressListId);
        }

        map.put("result", addressListData != null);
        map.put("addressListData", addressListData);

        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getAddressListById", method = RequestMethod.GET)
    public String getAddressListByAddressListId(
            @RequestParam(value = "addressListId") long addressListId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/addressList/getAddressListById   addressListId=" + addressListId);

        Map<String, Object> map = Maps.newHashMap();
        AddressListData addressListData = addressListService.getAddressListById(addressListId);

        map.put("addressListData", addressListData);
        return OAWebUtils.toJsonp(map);
    }


    @RequestMapping(params = "method=getAddressListList", method = RequestMethod.GET)
    public String getAddressListList(
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/addressList/getAddressListList");

        Map<String, Object> map = Maps.newHashMap();
        List<AddressListData> addressListList = addressListService.getAddressListList();

        map.put("addressListList", addressListList);

        return OAWebUtils.toJsonp(map);
    }

}
