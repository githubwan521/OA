package motian.controller;

import com.google.common.collect.Maps;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/11
 */

@RestController
@RequestMapping(testController.URLMAPPING)

public class testController {
    public static final String URLMAPPING = "/oa/test";
    public static final Log log = LogFactory.getLog(testController.class);

    @RequestMapping(params = "method=test", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> test(HttpServletRequest request, HttpServletResponse response) {
        log.debug("start");
        Map map = Maps.newHashMap();
        map.put("test", "test");
        return map;
    }
}
