package indi.orange1438.managementsystem.interceptor;

import com.alibaba.fastjson.JSON;
import indi.orange1438.managementsystem.dto.BaseResult;
import indi.orange1438.managementsystem.util.Const;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 用户登录拦截器
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/04/11 15:53
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 拦截前处理
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object sessionObj = httpServletRequest.getSession().getAttribute(Const.SESSION_USER);
        if (sessionObj != null) {
            return true;
        }
        System.out.println("no login:" + httpServletRequest.getMethod());
        if ("POST".equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.write(JSON.toJSONString(new BaseResult(false, "未登录！")));
            out.flush();
            out.close();
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "toLogin");
        }
        return false;
    }

    /**
     * 拦截后处理
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 全部完成后处理
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
