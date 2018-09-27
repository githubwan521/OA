package motian.service;

import motian.dao.manager.AddressListManager;
import motian.dao.model.AddressListData;
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
public class AddressListService {
    private static final Log LOG = LogFactory.getLog(AddressListService.class);

    @Autowired
    private AddressListManager AddressListManager;

    @Transactional
    public AddressListData addAddressList(long user_id) {
        AddressListData addressListData = new AddressListData(user_id);
        addressListData.setAl_id(OAServiceUtils.generateId());

        boolean res = 1 == AddressListManager.insert(addressListData);

        return res ? addressListData : null;
    }

    @Transactional
    public AddressListData updateAddressList(long al_id, long user_id) {
        AddressListData AddressListData = getAddressListById(al_id);


        if (!StringUtils.isEmpty(user_id)) {
            AddressListData.setUser_id(user_id);
        }


        boolean res = 1 == AddressListManager.update(AddressListData);
        return res ? AddressListData : null;
    }

    public AddressListData getAddressListById(long al_id) {
        return AddressListManager.getAddressListById(al_id);
    }

    public List<AddressListData> getAddressListList() {
        return AddressListManager.getAddressListList();
    }
}
