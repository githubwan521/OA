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
public class ConferenceRoomData extends BaseData {
    private long cr_id;
    @NonNull
    private String cr_name;
    @NonNull
    private String cr_status;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("cr_id", cr_id);
        objMap.put("cr_name", cr_name);
        objMap.put("cr_status", cr_status);

        return objMap;
    }
}
