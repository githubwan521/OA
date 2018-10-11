package motian.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
public class UserInfoData extends BaseData {
    private long userId;
    private String pass;
    private String introduce;
    private String interest;
    private String telephone;

    @Override
    protected Object toJsonStructuredObject() {
        HashMap<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("userId", userId);
        objMap.put("pass", pass);
        objMap.put("introduce", introduce);
        objMap.put("interest", interest);
        objMap.put("telephone", telephone);

        return objMap;
    }
}
