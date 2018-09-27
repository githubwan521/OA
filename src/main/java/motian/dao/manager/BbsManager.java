package motian.dao.manager;

import motian.dao.mapper.BbsMapper;
import motian.dao.model.BbsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/14 11:24
 */
@Repository
public class BbsManager {
    @Autowired
    private BbsMapper mapper;

    public int insert(BbsData bbs) {
        BbsData bbsTem = getBbsById(bbs.getBbs_id());
        if (StringUtils.isEmpty(bbsTem)) {
            return mapper.insert(bbs);
        }
        return 0;
    }

    public int update(BbsData BbsData) {
        return mapper.update(BbsData);
    }

    public BbsData getBbsById(long bbs_id) {
        return mapper.getBbsById(bbs_id);
    }

    public BbsData getBbsByUserId(long user_id) {
        return mapper.getBbsByUserId(user_id);
    }

    public List<BbsData> getBbsList() {
        return mapper.getBbsList();
    }

}