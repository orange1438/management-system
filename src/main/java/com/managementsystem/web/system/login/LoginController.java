package com.managementsystem.web.system.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 总入口
 */
@Controller
public class LoginController{

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
	public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	 * 请求登录，验证用户
	 */
	@RequestMapping(value="/login_login" ,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object login()throws Exception{

		return null;
	}
	
	/**
	 * 访问系统首页
	 */
	@RequestMapping(value="/main/{changeMenu}")
	public ModelAndView login_index(@PathVariable("changeMenu") String changeMenu){
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
