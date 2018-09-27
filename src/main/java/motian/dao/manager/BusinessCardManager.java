package motian.dao.manager;

import motian.dao.mapper.BusinessCardMapper;
import motian.dao.model.BusinessCardData;
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
public class BusinessCardManager {
    @Autowired
    private BusinessCardMapper mapper;

    public int insert(BusinessCardData businessCardHolder) {
        BusinessCardData user = getBusinessCardById(businessCardHolder.getCard_id());
        if (StringUtils.isEmpty(user)) {
            return mapper.insert(businessCardHolder);
        }
        return 0;
    }

    public int update(BusinessCardData BusinessCardData) {
        return mapper.update(BusinessCardData);
    }

    public BusinessCardData getBusinessCardById(long card_id) {
        return mapper.getBusinessCardById(card_id);
    }


    public List<BusinessCardData> getBusinessCardList() {
        return mapper.getBusinessCardList();
    }

}