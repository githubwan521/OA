package motian.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import motian.dao.model.AbstractJsonObject;
import motian.dao.model.IJsonSerializable;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 22:31
 */
public class OAWebUtils {

    public static Map<String, Object> toJsonObject(Map<String, Object> model) {
        Map<String, Object> res = Maps.newHashMap();
        if (model == null) {
            return res;
        }

        for (Map.Entry<String, Object> entry : model.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();

            if (v instanceof IJsonSerializable) {
                JSONObject json = JSONObject.parseObject(
                        ((IJsonSerializable) v).toJsonString());
                res.put(k, json);
            } else if (v instanceof Collection) {
                JSONArray array = toJsonArray((Collection) v);
                res.put(k, array);
            } else if (v instanceof Map) {
                JSONObject json = JSONObject.parseObject(
                        AbstractJsonObject.toJsonString((Map<String, Object>) v));
                res.put(k, json);
            } else {
                res.put(k, v);
            }
        }
        return res;
    }

    private static JSONArray toJsonArray(Collection v) {
        JSONArray array = new JSONArray();
        v.forEach(
                (obj) -> {
                    if (obj instanceof IJsonSerializable) {
                        JSONObject json = JSONObject
                                .parseObject(((IJsonSerializable) obj)
                                        .toJsonString());
                        array.add(json);
                    } else {
                        array.add(obj);
                    }
                }
        );
        return array;
    }
}
