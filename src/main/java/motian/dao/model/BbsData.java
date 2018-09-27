package motian.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 10:54
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BbsData extends BaseData {
    private long bbs_id;
    private String user_id;
    private String send_id;
    private String recv_id;
    private String title;
    private String content;
    private String status;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("bbs_id", bbs_id);
        objMap.put("user_id", user_id);
        objMap.put("send_id", send_id);
        objMap.put("recv_id", recv_id);
        objMap.put("title", title);
        objMap.put("content", content);
        objMap.put("status", status);

        return objMap;
    }
}
