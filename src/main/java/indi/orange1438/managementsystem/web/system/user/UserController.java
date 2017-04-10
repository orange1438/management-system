package indi.orange1438.managementsystem.web.system.user;

import com.github.pagehelper.PageInfo;
import indi.orange1438.managementsystem.dao.entity.Role;
import indi.orange1438.managementsystem.dao.entity.User;
import indi.orange1438.managementsystem.dao.entity.UserRole;
import indi.orange1438.managementsystem.dto.BaseResult;
import indi.orange1438.managementsystem.dto.PageDTO;
import indi.orange1438.managementsystem.dto.UserRoleDTO;
import indi.orange1438.managementsystem.service.system.RoleService;
import indi.orange1438.managementsystem.service.system.UserRoleService;
import indi.orange1438.managementsystem.service.system.UserService;
import indi.orange1438.managementsystem.util.*;
import indi.orange1438.managementsystem.util.SecurityUtils.DecodeUtils;
import indi.orange1438.managementsystem.web.system.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/29 10:46
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Resource(name = "userService")
    UserService userService;

    @Resource(name = "roleService")
    private RoleService roleService;

    @Resource(name = "userRoleService")
    private UserRoleService userRoleService;

    /**
     * 显示用户列表(用户组)
     */
    @RequestMapping
    public ModelAndView list() throws Exception {
        ModelAndView mv = this.getModelAndView();

        // 接收post请求的参数
        Map requestMap = this.getParameterMapByPost();
        String userName = null == requestMap.get("userName") ? "" : DecodeUtils.urlDecode(requestMap.get("userName").toString());
        String lastLoginStart = null == requestMap.get("lastLoginStart") ? "" : DecodeUtils.urlDecode(requestMap.get("lastLoginStart").toString());
        String lastLoginEnd = null == requestMap.get("lastLoginEnd") ? "" : DecodeUtils.urlDecode(requestMap.get("lastLoginEnd").toString());

        // 接收get请求的参数
        Map requestGetMap = this.getParameterMapByGet();
        int currentPage = null == requestGetMap.get("pageNum") ? 1 : Integer.valueOf(DecodeUtils.urlDecode(requestGetMap.get("pageNum").toString()));
        int showCount = null == requestGetMap.get("pageSize") ? 10 : Integer.valueOf(DecodeUtils.urlDecode(requestGetMap.get("pageSize").toString()));

        if (null != userName && !"".equals(userName)) {
            userName = userName.trim();
            requestMap.put("userName", userName);
        }

        if (lastLoginStart != null && !"".equals(lastLoginStart)) {
            lastLoginStart = lastLoginStart + " 00:00:00";
            requestMap.put("lastLoginStart", lastLoginStart);
        }
        if (lastLoginEnd != null && !"".equals(lastLoginEnd)) {
            lastLoginEnd = lastLoginEnd + " 23:59:59";
            requestMap.put("lastLoginEnd", lastLoginEnd);
        }

        List<UserRoleDTO> userList = userService.getUserByMap(requestMap, currentPage, showCount);            //列出用户列表
        mv.addObject("userList", userList);

        List<Role> roleList = roleService.getAllRole();                                //列出所有二级角色
        mv.addObject("roleList", roleList);

        Map rolePermissionMenuMap = (Map) this.getSession().getAttribute(Const.SESSION_ROLE_PERMISSION);
        mv.addObject("permission", rolePermissionMenuMap.get(Const.PERMISSION_USER));

        mv.addObject("requestMap", requestMap);

        PageDTO pageDTO = new PageDTO(new PageInfo(userList));
        mv.addObject("page", pageDTO);

        mv.setViewName("system/user/user_list");
        return mv;
    }

    /**
     * 新增用户页面
     */
    @RequestMapping(value = "/toAdd")
    public ModelAndView toAdd() throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            List<Role> roleList = roleService.getAllRole();                                //列出所有二级角色
            mv.setViewName("system/user/user_edit");
            mv.addObject("action", "/user/add.do");
            mv.addObject("roleList", roleList);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 新增用户
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        String userName = null == requestMap.get("userName") ? "" : DecodeUtils.urlDecode(requestMap.get("userName").toString());
        String password = null == requestMap.get("password") ? "" : DecodeUtils.urlDecode(requestMap.get("password").toString());
        String email = null == requestMap.get("email") ? "" : DecodeUtils.urlDecode(requestMap.get("email").toString());
        String mobile = null == requestMap.get("mobile") ? "" : DecodeUtils.urlDecode(requestMap.get("mobile").toString());
        String trueName = null == requestMap.get("trueName") ? "" : DecodeUtils.urlDecode(requestMap.get("trueName").toString());
        String roleId = null == requestMap.get("roleId") ? "" : requestMap.get("roleId").toString();

        User currentUser = (User) this.getSession().getAttribute(Const.SESSION_USER);

        // sys_user
        User user = new User();
        user.setUserId(IdGeneratorUtils.getInstance().nextId());
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setTrueName(trueName);
        user.setParentId(currentUser.getUserId());
        TableProperties.createProperties(user, currentUser.getTrueName());
        TableProperties.modifyProperties(user, currentUser.getTrueName());

        // sys_user_role
        UserRole userRole = new UserRole();
        userRole.setUserRoleId(IdGeneratorUtils.getInstance().nextId());
        userRole.setUserId(user.getUserId());
        userRole.setRoleId(Long.valueOf(roleId));
        TableProperties.createProperties(userRole, currentUser.getTrueName());
        TableProperties.modifyProperties(userRole, currentUser.getTrueName());

        return userService.insertUserByUserAndUserRole(user, userRole) > 0 ? new BaseResult(true, "新增用户成功！！！") : new BaseResult(false, "新增用户失败！！！");
    }

    /**
     * 编辑用户页面
     */
    @RequestMapping(value = "/toEdit")
    public ModelAndView toEdit() throws Exception {
        ModelAndView mv = this.getModelAndView();
        Map requestMap = this.getParameterMapByGet();
        String userId = null == requestMap.get("userId") ? "" : requestMap.get("userId").toString();

        try {
            UserRoleDTO user = userService.getUserRoleByUserId(Long.valueOf(userId));
            List<Role> roleList = roleService.getAllRole();                                //列出所有二级角色
            mv.setViewName("system/user/user_edit");
            mv.addObject("user", user);
            mv.addObject("roleList", roleList);
            mv.addObject("action", "/user/edit.do");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 编辑用户
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public Object edit() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        Long userId = null == requestMap.get("userId") ? null : Long.valueOf(requestMap.get("userId").toString());
        String userName = null == requestMap.get("userName") ? "" : DecodeUtils.urlDecode(requestMap.get("userName").toString());
        String password = null == requestMap.get("password") ? "" : DecodeUtils.urlDecode(requestMap.get("password").toString());
        String email = null == requestMap.get("email") ? "" : DecodeUtils.urlDecode(requestMap.get("email").toString());
        String mobile = null == requestMap.get("mobile") ? "" : DecodeUtils.urlDecode(requestMap.get("mobile").toString());
        String trueName = null == requestMap.get("trueName") ? "" : DecodeUtils.urlDecode(requestMap.get("trueName").toString());
        String roleId = null == requestMap.get("roleId") ? null : requestMap.get("roleId").toString();

        User currentUser = (User) this.getSession().getAttribute(Const.SESSION_USER);

        // sys_user
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setTrueName(trueName);
        TableProperties.modifyProperties(user, currentUser.getTrueName());

        // sys_user_role
        UserRole userRole = userRoleService.getUserRoleByUserId(userId);
        userRole.setRoleId(Long.valueOf(roleId));
        TableProperties.modifyProperties(userRole, currentUser.getTrueName());

        return userService.updateUserByUserAndUserRole(user, userRole) > 0 ? new BaseResult(true, "修改用户成功！！！") : new BaseResult(false, "修改用户失败！！！");
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object delete(@RequestParam String userId) throws Exception {
        return userService.deleteUser(Long.valueOf(userId)) > 0 ? new BaseResult(true, "删除用户成功！！！") : new BaseResult(false, "删除用户失败！！！");
    }

    /**
     * 批量删除
     */
    @RequestMapping(value = "/deleteAllUser")
    @ResponseBody
    public Object deleteAllUser() throws Exception {
        // 接收post请求的参数
        Map requestMap = this.getParameterMapByPost();

        String userIds = null == requestMap.get("userIds") ? "" : DecodeUtils.urlDecode(requestMap.get("userIds").toString());
        if (null != userIds && !"".equals(userIds)) {
            String arrayUserIds[] = userIds.split(",");
            return userService.deleteAllUser(Arrays.asList(arrayUserIds)) > 0 ? new BaseResult(true, "批量删除用户成功！！！") : new BaseResult(false, "批量删除用户失败！！！");
        } else {
            return new BaseResult(false, "批量删除用户失败！！！");
        }
    }

    /**
     * 导出用户信息到EXCEL
     *
     * @return
     */
    @RequestMapping(value = "/excel")
    public ModelAndView exportExcel() {
        ModelAndView mv = this.getModelAndView();

        // 接收get请求的参数
        Map requestGetMap = this.getParameterMapByGet();
        try {
            //检索条件===
            String userName = null == requestGetMap.get("userName") ? "" : DecodeUtils.urlDecode(requestGetMap.get("userName").toString());
            String lastLoginStart = null == requestGetMap.get("lastLoginStart") ? "" : DecodeUtils.urlDecode(requestGetMap.get("lastLoginStart").toString());
            String lastLoginEnd = null == requestGetMap.get("lastLoginEnd") ? "" : DecodeUtils.urlDecode(requestGetMap.get("lastLoginEnd").toString());

            if (null != userName && !"".equals(userName)) {
                userName = userName.trim();
                requestGetMap.put("userName", userName);
            }
            if (lastLoginStart != null && !"".equals(lastLoginStart)) {
                lastLoginStart = lastLoginStart + " 00:00:00";
                requestGetMap.put("lastLoginStart", lastLoginStart);
            }
            if (lastLoginEnd != null && !"".equals(lastLoginEnd)) {
                lastLoginEnd = lastLoginEnd + " 00:00:00";
                requestGetMap.put("lastLoginEnd", lastLoginEnd);
            }


            Map<String, Object> dataMap = new HashMap<String, Object>();
            List<String> titles = new ArrayList<String>();
            titles.add("编号");         //1
            titles.add("用户名");        //2
            titles.add("姓名");            //3
            titles.add("职位");            //4
            titles.add("手机");            //5
            titles.add("邮箱");            //6
            titles.add("最近登录");        //7
            titles.add("上次登录IP");        //8

            dataMap.put("titles", titles);

            List<UserRoleDTO> userList = userService.getUserByMap(requestGetMap);
            List<Map<String, String>> varList = new ArrayList<Map<String, String>>();
            for (UserRoleDTO userRoleDTO : userList) {
                Map<String, String> vpd = new HashMap();
                vpd.put("var1", userRoleDTO.getUserId().toString());       //1
                vpd.put("var2", userRoleDTO.getUserName());          //2
                vpd.put("var3", userRoleDTO.getTrueName());              //3
                vpd.put("var4", userRoleDTO.getRoleName());      //4
                vpd.put("var5", userRoleDTO.getMobile());          //5
                vpd.put("var6", userRoleDTO.getEmail());          //6
                vpd.put("var7", DateUtils.date2Str(userRoleDTO.getLastLoginTime()));      //7
                vpd.put("var8", userRoleDTO.getLoginIp());              //8
                varList.add(vpd);
            }
            dataMap.put("excelList", varList);
            ObjectExcelView erv = new ObjectExcelView();                    //执行excel操作
            mv = new ModelAndView(erv, dataMap);

        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 是否禁用用户
     *
     * @param userId
     * @param value
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/disabled", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object disabled(@RequestParam String userId, @RequestParam String value) throws Exception {
        User user = new User();
        user.setUserId(Long.valueOf(userId));
        user.setIsDisabled("false".equals(value) ? false : true);
        return userService.updateUserByUserId(user) > 0 ? new BaseResult(true, "设置成功！！！") : new BaseResult(false, "设置失败！！！");
    }

    /**
     * 判断用户名是否存在
     */
    @RequestMapping(value = "/existUserName")
    @ResponseBody
    public Object existUserName() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        try {
            String userName = null == requestMap.get("userName") ? "" : DecodeUtils.urlDecode(requestMap.get("userName").toString());
            if (userService.getUserEntityByUserName(userName) != null) {
                return new BaseResult(false, "用户存在");
            }
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return new BaseResult(true, "用户不存在");
    }

    /**
     * 判断邮箱是否存在
     */
    @RequestMapping(value = "/existEmail")
    @ResponseBody
    public Object existEmail() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        try {
            String email = null == requestMap.get("email") ? "" : DecodeUtils.urlDecode(requestMap.get("email").toString());
            if (userService.getUserEntityByEmail(email) != null) {
                return new BaseResult(false, "邮箱已存在");
            }
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return new BaseResult(true, "邮箱不存在");
    }

}
