package motian.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 10:54
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ConferenceRoomReservationData extends BaseData {
    private long crr_id;
    @NonNull
    private String applicant_id;
    @NonNull
    private String cr_id;
    @NonNull
    private String cre_ids;
    @NonNull
    private String user_ids;
    @NonNull
    private String start_time;
    @NonNull
    private String end_time;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("crr_id", crr_id);
        objMap.put("applicant_id", applicant_id);
        objMap.put("cr_id", cr_id);
        objMap.put("cre_ids", cre_ids);
        objMap.put("user_ids", user_ids);
        objMap.put("start_time", start_time);
        objMap.put("end_time", end_time);

        return objMap;
    }
}
