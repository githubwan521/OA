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
public class ScheduleData extends BaseData {
    private long schedule_id;
    @NonNull
    private String user_id;
    @NonNull
    private String readers_id;
    @NonNull
    private String assign_id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private String start_time;
    @NonNull
    private String end_time;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("schedule_id", schedule_id);
        objMap.put("user_id", user_id);
        objMap.put("readers_id", readers_id);
        objMap.put("assign_id", assign_id);
        objMap.put("title", title);
        objMap.put("content", content);
        objMap.put("start_time", start_time);
        objMap.put("end_time", end_time);

        return objMap;
    }
}
