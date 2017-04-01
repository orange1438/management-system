package indi.orange1438.managementsystem.web.system.user;

import indi.orange1438.managementsystem.dao.entity.Role;
import indi.orange1438.managementsystem.dao.entity.User;
import indi.orange1438.managementsystem.dao.entity.UserRole;
import indi.orange1438.managementsystem.dto.BaseResult;
import indi.orange1438.managementsystem.dto.UserRoleDTO;
import indi.orange1438.managementsystem.service.system.RoleService;
import indi.orange1438.managementsystem.service.system.UserRoleService;
import indi.orange1438.managementsystem.service.system.UserService;
import indi.orange1438.managementsystem.util.Const;
import indi.orange1438.managementsystem.util.IdGeneratorUtils;
import indi.orange1438.managementsystem.util.SecurityUtils.DecodeUtils;
import indi.orange1438.managementsystem.util.TableProperties;
import indi.orange1438.managementsystem.web.system.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map requestMap = this.getParameterMapByPost();
        String userName = null == requestMap.get("userName") ? "" : DecodeUtils.urlDecode(requestMap.get("userName").toString());
        String lastLoginStart = null == requestMap.get("lastLoginStart") ? "" : DecodeUtils.urlDecode(requestMap.get("lastLoginStart").toString());
        String lastLoginEnd = null == requestMap.get("lastLoginEnd") ? "" : DecodeUtils.urlDecode(requestMap.get("lastLoginEnd").toString());

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

        List<UserRoleDTO> userList = userService.getUserByMap(requestMap);            //列出用户列表

        List<Role> roleList = roleService.getAllRole();                                //列出所有二级角色

        mv.setViewName("system/user/user_list");
        mv.addObject("userList", userList);
        mv.addObject("roleList", roleList);
        mv.addObject("requestMap", requestMap);
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
        user.setMobile(mobile);
        user.setTrueName(trueName);
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
            User user = userService.getUserEntityByUserId(Long.valueOf(userId));
            List<Role> roleList = roleService.getAllRole();                                //列出所有二级角色
            mv.setViewName("system/user/user_edit");
            mv.addObject("action", "/user/edit.do");
            mv.addObject("roleList", roleList);
            mv.addObject("user", user);
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
     * 判断用户名是否存在
     */
    @RequestMapping(value = "/existUserName")
    @ResponseBody
    public Object existUserName() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        try {
            String userName = null == requestMap.get("userName") ? "" : requestMap.get("userName").toString();
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
            String userName = null == requestMap.get("userName") ? "" : requestMap.get("userName").toString();
            String email = null == requestMap.get("email") ? "" : requestMap.get("email").toString();
            if (userService.getUserEntityByEmail(email, userName) != null) {
                return new BaseResult(false, "邮箱存在");
            }
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return new BaseResult(true, "邮箱不存在");
    }

}
