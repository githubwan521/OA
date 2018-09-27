package motian.dao.mapper;

import motian.dao.model.NoteData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/27 9:04
 */
public interface NoteMapper {
    int insert(@Param("data") NoteData data);

    int update(NoteData data);

    NoteData getNoteById(@Param("note_id") long note_id);

    List<NoteData> getNoteList();

}
