package motian.dao.manager;

import motian.dao.mapper.NoteMapper;
import motian.dao.model.NoteData;
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
public class NoteManager {
    @Autowired
    private NoteMapper mapper;

    public int insert(NoteData bbs) {
        NoteData bbsTem = getNoteById(bbs.getNote_id());
        if (StringUtils.isEmpty(bbsTem)) {
            return mapper.insert(bbs);
        }
        return 0;
    }

    public int update(NoteData NoteData) {
        return mapper.update(NoteData);
    }


    public NoteData getNoteById(long note_id) {
        return mapper.getNoteById(note_id);
    }

    public List<NoteData> getNoteList() {
        return mapper.getNoteList();
    }

}