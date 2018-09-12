package motian.dao.model;

import com.google.common.collect.Lists;
import net.sf.json.util.JSONUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 23:29
 */
public abstract class AbstractJsonObject implements IJsonSerializable {

    public String toJsonString() {
        return printValue(toJsonStructuredObject());
    }

    public static String toJsonString(Map<String, Object> model) {
        return printValue(model);
    }


    protected abstract Object toJsonStructuredObject();

    private static String printValue(Object value) {
        if (List.class.isInstance(value)) {
            return printArray((List<Object>) value);
        } else if (Map.class.isInstance(value)) {
            return printObject((Map<Object, Object>) value);
        } else if (Set.class.isInstance(value)) {
            return printArray(Lists.newArrayList((Set<Object>) value));
        } else if (value instanceof IJsonSerializable) {
            return ((IJsonSerializable) value).toJsonString();
        } else {
            return JSONUtils.valueToString(value);
        }
    }


    private static String printArray(List<Object> lstValues) {
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Object obj : lstValues) {
            if (flag) {
                flag = false;
            } else {
                sb.append(",");
            }
            sb.append(printValue(obj));
        }
        sb.append("]");
        return sb.toString();
    }


    private static String printObject(Map<Object, Object> mapValues) {
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (Map.Entry<Object, Object> entry : mapValues.entrySet()) {
            if (flag) {
                flag = false;
            } else {
                sb.append(",");
            }
            sb.append(printValue(String.valueOf(entry.getKey())));
            sb.append(":");
            sb.append(printValue(entry.getValue()));
        }
        sb.append("}");
        return sb.toString();
    }
}
