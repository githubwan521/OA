package motian.dao.manager;

import motian.dao.mapper.SundryMapper;
import motian.dao.model.SundryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 15:31
 */
@Repository
public class SundryManager {

    @Autowired
    private SundryMapper mapper;

    public int insert(SundryData sundryData) {
        SundryData sundry = getSundry(sundryData.getKey(), sundryData.getValue());
        if (StringUtils.isEmpty(sundry)) {
            return mapper.insert(sundryData);
        }
        return 0;
    }

    public int update(SundryData sundryData) {
        return mapper.update(sundryData);
    }

    public SundryData getSundry(String key, String value) {
        return mapper.getSundry(key, value);
    }

    public SundryData getSundryById(long sundryId) {
        return mapper.getSundryById(sundryId);

    }

    public List<SundryData> getSundryList(String key) {
        return mapper.getSundryList(key);
    }

}
