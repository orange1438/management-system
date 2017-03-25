package indi.orange1438.managementsystem.web.system.head;

import indi.orange1438.managementsystem.dao.entity.User;
import indi.orange1438.managementsystem.service.system.UserService;
import indi.orange1438.managementsystem.util.Const;
import indi.orange1438.managementsystem.web.system.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HeadController
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/08 16:25
 */
@Controller
@RequestMapping(value = "/head")
public class HeadController extends BaseController {

    @Resource(name = "userService")
    private UserService userService;

    /**
     * 获取头部信息
     */
    @RequestMapping(value = "/getUser")
    @ResponseBody
    public Object getList() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            HttpSession session = this.getSession();
            User user = (User) session.getAttribute(Const.SESSION_USER);//获取当前登录者信息
            map.put("user", null == user ? new User() : user);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return map;
    }

    /**
     * 保存皮肤
     */
    @RequestMapping(value = "/setSkin", method = RequestMethod.GET)
    public void setSkin(PrintWriter out) throws Exception {
        Map requestMap = this.getParameterMapByGet();
        HttpSession session = this.getSession();
        try {
            String skin = null == requestMap.get("skin") ? null : requestMap.get("skin").toString();
            if (null != skin) {
                User user = (User) session.getAttribute(Const.SESSION_USER);//获取当前登录者信息
                user.setSkin(skin);
                userService.updateUserByUserId(user);
                session.setAttribute(Const.SESSION_USER, user);
            }
            out.write("success");
            out.close();
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }

    }
}
