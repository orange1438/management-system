package indi.orange1438.managementsystem.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Ip工具类
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/28 22:53
 */
public class IpUtils {
    /**
     * 获取登录用户的IP
     *
     * @throws Exception
     */
    public static final String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
