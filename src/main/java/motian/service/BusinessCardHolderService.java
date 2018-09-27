package motian.service;

import motian.dao.manager.BusinessCardHolderManager;
import motian.dao.model.BusinessCardHolderData;
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
public class BusinessCardHolderService {
    private static final Log LOG = LogFactory.getLog(BusinessCardHolderService.class);

    @Autowired
    private BusinessCardHolderManager BusinessCardHolderManager;

    @Transactional
    public BusinessCardHolderData addBusinessCardHolder(String bch_name,String user_id) {
        BusinessCardHolderData addressListData = new BusinessCardHolderData(bch_name,user_id);
        addressListData.setBch_id(OAServiceUtils.generateId());

        boolean res = 1 == BusinessCardHolderManager.insert(addressListData);

        return res ? addressListData : null;
    }

    @Transactional
    public BusinessCardHolderData updateBusinessCardHolder(long bch_id, String user_id,String bch_name) {
        BusinessCardHolderData BusinessCardHolderData = getBusinessCardHolderById(bch_id);


        if (!StringUtils.isEmpty(user_id)) {
            BusinessCardHolderData.setUser_id(user_id);
        }
        if (!StringUtils.isEmpty(bch_name)) {
            BusinessCardHolderData.setBch_name(bch_name);
        }


        boolean res = 1 == BusinessCardHolderManager.update(BusinessCardHolderData);
        return res ? BusinessCardHolderData : null;
    }

    public BusinessCardHolderData getBusinessCardHolderById(long bch_id) {
        return BusinessCardHolderManager.getBusinessCardHolderById(bch_id);
    }

    public List<BusinessCardHolderData> getBusinessCardHolderList() {
        return BusinessCardHolderManager.getBusinessCardHolderList();
    }
}
