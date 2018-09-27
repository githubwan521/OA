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
public class ConferenceRoomEquipmentData extends BaseData {
    private long cre_id;
    @NonNull
    private String cre_name;
    @NonNull
    private String cre_info;
    @NonNull
    private String cre_status;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("cre_id", cre_id);
        objMap.put("cre_name", cre_name);
        objMap.put("cre_info", cre_info);
        objMap.put("cre_status", cre_status);

        return objMap;
    }
}
