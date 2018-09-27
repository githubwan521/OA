package motian.controller;

import com.google.common.collect.Maps;
import motian.dao.model.NoteData;
import motian.service.NoteService;
import motian.utils.OAWebUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 21:56
 */

@RestController
@RequestMapping(NoteController.URLMAPPING)
public class NoteController extends AbstractController {
    static final String URLMAPPING = "/oa/Note";
    private static final Log LOG = LogFactory.getLog(NoteController.class);

    @Autowired
    NoteService NoteService;

    @RequestMapping(params = "method=addNote", method = RequestMethod.POST)
    public String addNote(
            @RequestParam(value = "applicant_id") String applicant_id,
            @RequestParam(value = "user_id") String user_id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/Note/addNote   " + "applicant_id=" + applicant_id);

        Map<String, Object> map = Maps.newHashMap();
        NoteData NoteData = NoteService.
                addNote(user_id, title, content);
        if (StringUtils.isEmpty(NoteData)) {
            LOG.warn("fail to add Note." + "applicant_id=" + applicant_id);
        }

        map.put("result", NoteData != null);
        map.put("NoteData", NoteData);
        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=updateNote", method = RequestMethod.POST)
    public String updateNote(
            @RequestParam(value = "note_id") long note_id,
            @RequestParam(value = "applicant_id") String applicant_id,
            @RequestParam(value = "cr_id") String cr_id,
            @RequestParam(value = "cre_ids") String cre_ids,
            @RequestParam(value = "user_id") String user_id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/Note/updateNote   " +
                "note_id=" + note_id);

        Map<String, Object> map = Maps.newHashMap();
        NoteData NoteData = NoteService.updateNote(note_id,
                user_id, title, content);
        if (StringUtils.isEmpty(NoteData)) {
            LOG.warn("fail to update Note." + "note_id=" + note_id);
        }

        map.put("result", NoteData != null);
        map.put("NoteData", NoteData);

        return OAWebUtils.toJsonp(map);
    }

    @RequestMapping(params = "method=getNoteById", method = RequestMethod.GET)
    public String getNoteByNoteId(
            @RequestParam(value = "NoteId") long NoteId,
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/Note/getNoteById   NoteId=" + NoteId);

        Map<String, Object> map = Maps.newHashMap();
        NoteData NoteData = NoteService.getNoteById(NoteId);

        map.put("NoteData", NoteData);
        return OAWebUtils.toJsonp(map);
    }


    @RequestMapping(params = "method=getNoteList", method = RequestMethod.GET)
    public String getNoteList(
            HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("/oa/Note/getNoteList");

        Map<String, Object> map = Maps.newHashMap();
        List<NoteData> NoteList = NoteService.getNoteList();

        map.put("NoteList", NoteList);

        return OAWebUtils.toJsonp(map);
    }

}
