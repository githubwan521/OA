package motian.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.UUID;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 21:38
 */
public class OAServiceUtils {
    private static final Log LOG = LogFactory.getLog(OAServiceUtils.class);

    private static final int DEFAULT_RANDOM_RANGE_BYTES = 10;

    /**
     * 生成随机10位 ID
     */
    public static long generateId() {
        if (OAServiceUtils.DEFAULT_RANDOM_RANGE_BYTES < 1) {
            return 0;
        }
        long rangeMaxValue = 1 << OAServiceUtils.DEFAULT_RANDOM_RANGE_BYTES;

        long res = UUID.randomUUID().hashCode() & (rangeMaxValue - 1) + rangeMaxValue
                + (System.currentTimeMillis() << DEFAULT_RANDOM_RANGE_BYTES);

        return res;
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
