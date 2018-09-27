package motian.service;

import motian.dao.manager.NoteManager;
import motian.dao.model.NoteData;
import motian.utils.OAServiceUtils;
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
 * @Date: 2018/9/12 21:28
 */

@Service
public class NoteService {
    private static final Log LOG = LogFactory.getLog(NoteService.class);

    @Autowired
    private NoteManager NoteManager;

    @Transactional
    public NoteData addNote(String user_id, String title, String content) {
        NoteData addressListData = new NoteData(user_id, title, content);
        addressListData.setNote_id(OAServiceUtils.generateId());

        boolean res = 1 == NoteManager.insert(addressListData);

        return res ? addressListData : null;
    }

    @Transactional
    public NoteData updateNote(long note_id, String user_id, String title, String content) {
        NoteData NoteData = getNoteById(note_id);


        if (!StringUtils.isEmpty(user_id)) {
            NoteData.setUser_id(user_id);
        }
        if (!StringUtils.isEmpty(title)) {
            NoteData.setTitle(title);
        }
        if (!StringUtils.isEmpty(content)) {
            NoteData.setContent(content);
        }


        boolean res = 1 == NoteManager.update(NoteData);
        return res ? NoteData : null;
    }

    public NoteData getNoteById(long bch_id) {
        return NoteManager.getNoteById(bch_id);
    }

    public List<NoteData> getNoteList() {
        return NoteManager.getNoteList();
    }
}
