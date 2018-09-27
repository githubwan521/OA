package motian.dao.mapper;

import motian.dao.model.BusinessCardHolderData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 8:58
 */
public interface BusinessCardHolderMapper {
    int insert(@Param("data") BusinessCardHolderData data);

    int update(BusinessCardHolderData data);

    BusinessCardHolderData getBusinessCardHolderById(@Param("bch_id") long bch_id);

    List<BusinessCardHolderData> getBusinessCardHolderList();
}
