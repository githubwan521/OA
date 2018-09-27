package motian.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 10:54
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class AddressListData extends BaseData {
    private long al_id;
    @NonNull
    private long user_id;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("al_id", al_id);
        objMap.put("user_id", user_id);

        return objMap;
    }
}
