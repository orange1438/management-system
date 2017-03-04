package indi.orange1438.managementsystem.web.system.base;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.PanelUI;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共Controller
 * 包含所有Controller用的方法
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/04 14:18
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 得到 ModelAndView
     */
    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }

    /**
     * 得到 request 对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 得到 Session 对象
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 得到json数据请求的变量参数
     */
    public Map getParameterMap() {
        try {
            HttpServletRequest request = getRequest();
            request.setCharacterEncoding("UTF-8");
            String paramStr = IOUtils.toString(request.getInputStream(), "UTF-8");
            if (null == paramStr || paramStr.isEmpty()) {
                return new HashMap();
            }
            return (Map) JSON.parse(paramStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashMap();
    }

    /**
     * 根地址
     */
    public String getBasePath() {
        HttpServletRequest request = getRequest();
        String path = request.getContextPath();
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    }
}
