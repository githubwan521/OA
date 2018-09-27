package motian.dao.mapper;

import motian.dao.model.BbsData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 8:56
 */
public interface BbsMapper {
    int insert(@Param("data") BbsData data);

    int update(BbsData data);

    BbsData getBbsById(@Param("bbs_id") long bbs_id);

    BbsData getBbsByUserId(@Param("user_id") long user_id);

    List<BbsData> getBbsList();
}
