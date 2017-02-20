package indi.orange1438.managementsystem.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Request Parameter参数接收处理
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/02 20:44
 */
public class RequestParameter {

    public static Map getParameterMap() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            request.setCharacterEncoding("UTF-8");
            String paramStr = IOUtils.toString(request.getInputStream(), "UTF-8");
            return (Map) JSON.parse(paramStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
