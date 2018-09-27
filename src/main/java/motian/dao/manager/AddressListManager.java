package motian.dao.manager;

import motian.dao.mapper.AddressListMapper;
import motian.dao.model.AddressListData;
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
public class AddressListManager {
    @Autowired
    private AddressListMapper mapper;

    public int insert(AddressListData addressListData) {
        AddressListData user = getAddressListById(addressListData.getAl_id());
        if (StringUtils.isEmpty(user)) {
            return mapper.insert(addressListData);
        }
        return 0;
    }

    public int update(AddressListData AddressListData) {
        return mapper.update(AddressListData);
    }

    public AddressListData getAddressListById(long al_id) {
        return mapper.getAddressListById(al_id);
    }

    public AddressListData getAddressListByUserId(long user_id) {
        return mapper.getAddressListByUserId(user_id);
    }

    public List<AddressListData> getAddressListList() {
        return mapper.getAddressListList();
    }

}