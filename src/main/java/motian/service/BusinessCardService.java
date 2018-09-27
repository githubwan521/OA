package motian.service;

import motian.dao.manager.BusinessCardManager;
import motian.dao.model.BusinessCardData;
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
public class BusinessCardService {
    private static final Log LOG = LogFactory.getLog(BusinessCardService.class);

    @Autowired
    private BusinessCardManager BusinessCardManager;

    @Transactional
    public BusinessCardData addBusinessCard(String bch_id, String owner_id, String memoname
            , String friend_id, String attribute) {
        BusinessCardData addressListData = new BusinessCardData(bch_id, owner_id, memoname,
                friend_id, attribute);
        addressListData.setCard_id(OAServiceUtils.generateId());

        boolean res = 1 == BusinessCardManager.insert(addressListData);

        return res ? addressListData : null;
    }

    @Transactional
    public BusinessCardData updateBusinessCard(long card_id, String bch_id,
                                               String owner_id, String memonam, String friend_id, String attribute) {
        BusinessCardData BusinessCardData = getBusinessCardById(card_id);


        if (!StringUtils.isEmpty(bch_id)) {
            BusinessCardData.setBch_id(bch_id);
        }
        if (!StringUtils.isEmpty(owner_id)) {
            BusinessCardData.setOwner_id(owner_id);
        }
        if (!StringUtils.isEmpty(friend_id)) {
            BusinessCardData.setFriend_id(friend_id);
        }
        if (!StringUtils.isEmpty(attribute)) {
            BusinessCardData.setAttribute(attribute);
        }

        boolean res = 1 == BusinessCardManager.update(BusinessCardData);
        return res ? BusinessCardData : null;
    }

    public BusinessCardData getBusinessCardById(long bch_id) {
        return BusinessCardManager.getBusinessCardById(bch_id);
    }

    public List<BusinessCardData> getBusinessCardList() {
        return BusinessCardManager.getBusinessCardList();
    }
}
