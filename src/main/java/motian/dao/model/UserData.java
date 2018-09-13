package motian.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 16:41
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserData extends BaseData {
    private long userId;
    @NonNull
    private String nickname;
    @NonNull
    private int identity;
    @NonNull
    private int department;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("userId", userId);
        objMap.put("nickname", nickname);
        objMap.put("identity", identity);
        objMap.put("department", department);
      
        return objMap;
    }

}
