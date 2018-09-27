package motian.dao.mapper;

import motian.dao.model.BusinessCardData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 9:00
 */
public interface BusinessCardMapper {
    int insert(@Param("data") BusinessCardData data);

    int update(BusinessCardData data);

    BusinessCardData getBusinessCardById(@Param("card_id") long card_id);

    List<BusinessCardData> getBusinessCardList();

}
