package motian.service;

import motian.dao.manager.SundryManager;
import motian.dao.model.DataType;
import motian.dao.model.SundryData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 15:37
 */
@Service
public class SundryService {
    private static final Log LOG = LogFactory.getLog(SundryService.class);


    @Autowired
    private SundryManager sundryManager;

    @Transactional
    public SundryData addSundry(String key, String value) {
        SundryData sundryData = new SundryData(getKeyName(key), value);

        boolean res = 1 == sundryManager.insert(sundryData);
        return res ? sundryData : null;
    }

    @Transactional
    public SundryData updateSundry(long sundryId, String key, String value) {
        SundryData sundryData = sundryManager.getSundry(getKeyName(key), value);
        if (StringUtils.isEmpty(sundryData)) {
            LOG.warn("fail to updateSundry. " +
                    "keyAndType does not exist. key=" + key + "value" + value);
            return null;
        }
        if (!StringUtils.isEmpty(value)) {
            sundryData.setValue(value);
        }

        boolean res = 1 == sundryManager.update(sundryData);
        return res ? sundryData : null;
    }


    public SundryData getSundry(String key, String value) {
        return sundryManager.getSundry(getKeyName(key), value);
    }

    public SundryData getSundryById(long sundryId) {
        return sundryManager.getSundryById(sundryId);
    }

    public List<SundryData> getSundryList(String key) {
        return sundryManager.getSundryList(getKeyName(key));
    }

    public String getKeyName(String key) {
        if (key.equals(DataType.SundryType.IDENTITY.toString())) {
            key = DataType.SundryType.IDENTITY.toString();
        } else if (key.equals(DataType.SundryType.DEPARTMENT.toString())) {
            key = DataType.SundryType.DEPARTMENT.toString();
        } else {
            key = DataType.SundryType.UNKNOWN.toString();
        }
        return key;
    }
}
