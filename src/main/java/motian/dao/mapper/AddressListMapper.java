package motian.dao.mapper;

import motian.dao.model.AddressListData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 8:54
 */
public interface AddressListMapper {
    int insert(@Param("data") AddressListData data);

    int update(AddressListData data);

    AddressListData getAddressListById(@Param("al_id") long al_id);

    AddressListData getAddressListByUserId(@Param("user_id") long user_id);

    List<AddressListData> getAddressListList();

}
