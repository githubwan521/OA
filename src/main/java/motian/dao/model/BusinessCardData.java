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
public class BusinessCardData extends BaseData {
    private long card_id;
    @NonNull
    private String bch_id;
    @NonNull
    private String owner_id;
    @NonNull
    private String memoname;
    @NonNull
    private String friend_id;
    @NonNull
    private String attribute;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("bch_id", bch_id);
        objMap.put("owner_id", owner_id);
        objMap.put("memoname", memoname);
        objMap.put("friend_id", friend_id);
        objMap.put("attribute", attribute);

        return objMap;
    }
}
