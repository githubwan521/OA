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
public class NoteData extends BaseData {
    private long note_id;
    @NonNull
    private String user_id;
    @NonNull
    private String title;
    @NonNull
    private String content;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("note_id", note_id);
        objMap.put("user_id", user_id);
        objMap.put("title", title);
        objMap.put("content", content);

        return objMap;
    }
}
