package motian.dao.manager;

import motian.dao.mapper.BusinessCardHolderMapper;
import motian.dao.model.BusinessCardHolderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 11:24
 */
@Repository
public class BusinessCardHolderManager {
    @Autowired
    private BusinessCardHolderMapper mapper;

    public int insert(BusinessCardHolderData businessCardHolder) {
        BusinessCardHolderData user = getBusinessCardHolderById(businessCardHolder.getBch_id());
        if (StringUtils.isEmpty(user)) {
            return mapper.insert(businessCardHolder);
        }
        return 0;
    }

    public int update(BusinessCardHolderData BusinessCardHolderData) {
        return mapper.update(BusinessCardHolderData);
    }

    public BusinessCardHolderData getBusinessCardHolderById(long bch_id) {
        return mapper.getBusinessCardHolderById(bch_id);
    }


    public List<BusinessCardHolderData> getBusinessCardHolderList() {
        return mapper.getBusinessCardHolderList();
    }

}