package indi.orange1438.managementsystem.web.system.login;

import java.util.HashMap;
import java.util.Map;

import indi.orange1438.managementsystem.dao.entity.UserEntity;
import indi.orange1438.managementsystem.service.system.UserService;
import indi.orange1438.managementsystem.util.Const;
import indi.orange1438.managementsystem.util.RequestParameter;
import indi.orange1438.managementsystem.util.helper.StringHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
 * 总入口
 */
@Controller
public class LoginController{

	@Autowired
	private UserService userService;

	/**
	 * 获取登录用户的IP
	 * @throws Exception 
	 */
	public void getRemortIP(String USERNAME) throws Exception {
//		PageData pd = new PageData();
//		HttpServletRequest request = this.getRequest();
//		String ip = "";
//		if (request.getHeader("x-forwarded-for") == null) {
//			ip = request.getRemoteAddr();
//	    }else{
//	    	ip = request.getHeader("x-forwarded-for");
//	    }
//		pd.put("USERNAME", USERNAME);
//		pd.put("IP", ip);
//		userService.saveIP(pd);
	}  
	
	
	/**
	 * 访问登录页
	 * @return
	 */
	@RequestMapping(value="/login_toLogin")
	public ModelAndView toLoginPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

		Map map = new HashMap();
		map.put("SysName", "Orange"); //填入系统名称
		map.put("BasePath", basePath); // 根目录地址，为动静分离资源做准备，可能需要单独的静态服务器而准备的

		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/admin/login");
		mv.addAllObjects(map);

		return mv;
	}

	/**
	 * 请求登录接口，验证用户
	 */
	@RequestMapping(value = "/login_login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object loginApi() throws Exception {
		Map requestMap = RequestParameter.getParameterMap();
		String userName = null == requestMap.get("loginName") ? "" : requestMap.get("loginName").toString();
		String password = null == requestMap.get("password") ? "" : requestMap.get("password").toString();
		String code = null == requestMap.get("code") ? "" : requestMap.get("code").toString();

		String resultInfo = "";
		if (null != userName && null != password) {
			if (null == code || "".equals(code)) {
				resultInfo = "nullcode"; //验证码为空
			} else {
				// 获取session
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				HttpSession session = request.getSession();
				String sessionCode = session != null ? session.getAttribute(Const.SESSION_SECURITY_CODE).toString() : "";

				if (StringHelper.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)) {
					//shiro加入身份验证
					Subject subject = SecurityUtils.getSubject();
					UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
					try {
						subject.login(token);
					} catch (AuthenticationException e) {
						resultInfo = "usererror";       //用户名或密码有误
					}
				} else {
					resultInfo = "codeerror";                    //验证码输入有误
				}
				if (StringHelper.isEmpty(resultInfo)) {
					resultInfo = "success";                    //验证成功
				}
			}
		} else {
			resultInfo = "error";    //缺少参数
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("result", resultInfo);
		return map;
	}
	
	/**
	 * 访问系统首页
	 */
	@RequestMapping(value="/main/{changeMenu}")
	public ModelAndView loginIndexPage(@PathVariable("changeMenu") String changeMenu) {
		return null;
	}
	
	/**
	 * 进入tab标签
	 * @return
	 */
	@RequestMapping(value="/tab")
	public String tab(){
		return "system/admin/tab";
	}
	
	/**
	 * 进入首页后的默认页面
	 * @return
	 */
	@RequestMapping(value="/login_default")
	public String defaultPage(){
		return "system/admin/default";
	}
	
	/**
	 * 用户注销
	 * @param
	 * @return
	 */
	@RequestMapping(value="/logout")
	public ModelAndView logout(){
		return null;
	}


	
}
