package indi.orange1438.managementsystem.web.system.role;

import com.alibaba.fastjson.JSON;
import indi.orange1438.managementsystem.dao.entity.*;
import indi.orange1438.managementsystem.dto.BaseResult;
import indi.orange1438.managementsystem.dto.MenuDTO;
import indi.orange1438.managementsystem.service.system.*;
import indi.orange1438.managementsystem.util.BeanUtils;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/16 9:20
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    @Resource(name = "roleService")
    private RoleService roleService;

    @Resource(name = "groupService")
    private GroupService groupService;

    @Resource(name = "menuService")
    private MenuService menuService;

    @Resource(name = "permissionService")
    private PermissionService permissionService;

    @Resource(name = "rolePermissionService")
    private RolePermissionService rolePermissionService;

    /**
     * 列表
     */
    @RequestMapping
    public ModelAndView list() throws Exception {
        ModelAndView mv = this.getModelAndView();

        Group currentGroup = null;
        List<Role> roleList = null;
        List<Group> groupList = groupService.getAllGroup();                //列出所有组(有时候可以是部门的概念)
        if (null != groupList && 0 < groupList.size()) {
            Map requestMap = this.getParameterMapByGet();
            Long groupId = null == requestMap.get("groupId") ? groupList.get(0).getGroupId() : Long.valueOf(requestMap.get("groupId").toString());
            currentGroup = groupService.getGroupByGroupId(groupId);    // 当前组

            roleList = roleService.getRoleByGroupId(currentGroup.getGroupId());        //列出当前组的所有角色
        }

        mv.addObject("currentGroup", currentGroup);
        mv.addObject("groupList", groupList);
        mv.addObject("roleList", roleList);
        mv.setViewName("system/role/role_list");

        return mv;
    }

    /**
     * 新增角色页面
     */
    @RequestMapping(value = "/toAdd")
    public ModelAndView toAdd() throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            Map requestMap = this.getParameterMapByGet();
            requestMap.put("action", "/role/add.do");
            requestMap.put("name", "角色");
            mv.addObject("page", requestMap);
            mv.setViewName("system/role/page_add");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 新增接口
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object add() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        String groupId = null == requestMap.get("parentId") ? null : DecodeUtils.urlDecode(requestMap.get("parentId").toString());
        String roleName = null == requestMap.get("Name") ? null : DecodeUtils.urlDecode(requestMap.get("Name").toString());
        String description = null == requestMap.get("Description") ? null : DecodeUtils.urlDecode(requestMap.get("Description").toString());

        User user = (User) this.getSession().getAttribute(Const.SESSION_USER);

        Role role = new Role();
        role.setDescription(description);
        role.setRoleId(IdGeneratorUtils.getInstance().nextId());
        role.setRoleName(roleName);

        RoleGroup roleGroup = new RoleGroup();
        roleGroup.setGroupId(Long.valueOf(groupId));
        roleGroup.setRoleGroupId(IdGeneratorUtils.getInstance().nextId());
        roleGroup.setRoleId(role.getRoleId());


        List<RolePermission> rolePermissionList = new ArrayList<>();
        List<Permission> permissionList = permissionService.getPermissionByGroupId(Long.valueOf(groupId));
        for (Permission permission : permissionList) {
            //sys_role_permission(继承组菜单)
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRolePermissionId(IdGeneratorUtils.getInstance().nextId());
            rolePermission.setRoleId(role.getRoleId());
            rolePermission.setPermissionId(permission.getPermissionId());
            rolePermission.setAddRights(false);
            rolePermission.setEditRights(false);
            rolePermission.setDeleteRights(false);
            rolePermission.setViewRights(false);
            rolePermission.setExportRights(false);
            rolePermission.setImportRights(false);
            TableProperties.createProperties(rolePermission, user.getTrueName());
            TableProperties.modifyProperties(rolePermission, user.getTrueName());
            rolePermissionList.add(rolePermission);
        }

        TableProperties.createProperties(role, user.getTrueName());
        TableProperties.modifyProperties(role, user.getTrueName());
        TableProperties.createProperties(roleGroup, user.getTrueName());
        TableProperties.modifyProperties(roleGroup, user.getTrueName());


        return roleService.insertRole(role, roleGroup, rolePermissionList) > 0 ? new BaseResult(true, "新增角色成功！！！") : new BaseResult(false, "新增角色失败！！！");
    }

    /**
     * 编辑角色页面
     */
    @RequestMapping(value = "/toEdit")
    public ModelAndView toEdit() throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            Map requestMap = this.getParameterMapByGet();
            String roleId = null == requestMap.get("roleId") ? null : DecodeUtils.urlDecode(requestMap.get("roleId").toString());
            Role role = roleService.getRoleByRoleId(Long.valueOf(roleId));
            mv.addObject("role", role);

            requestMap.put("action", "/role/edit.do");
            requestMap.put("name", "角色");
            mv.addObject("page", requestMap);
            mv.setViewName("system/role/page_edit");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 编辑角色接口
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object edit() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        String roleId = null == requestMap.get("roleId") ? null : DecodeUtils.urlDecode(requestMap.get("roleId").toString());
        String roleName = null == requestMap.get("Name") ? null : DecodeUtils.urlDecode(requestMap.get("Name").toString());
        String description = null == requestMap.get("Description") ? null : DecodeUtils.urlDecode(requestMap.get("Description").toString());

        Role role = new Role();
        role.setDescription(description);
        role.setRoleId(Long.valueOf(roleId));
        role.setRoleName(roleName);

        User user = (User) this.getSession().getAttribute(Const.SESSION_USER);
        TableProperties.modifyProperties(role, user.getTrueName());

        return roleService.updateRoleByRoleId(role) > 0 ? new BaseResult(true, "编辑角色成功！！！") : new BaseResult(false, "编辑角色失败！！！");
    }

    /**
     * 删除角色
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object delete(@RequestParam String roleId) throws Exception {
        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add(Long.valueOf(roleId));
        // 如果角色被用户引用sys_user_role，则提示
        if (roleService.isHaveRoleByroleId(roleIdList)) {
            new BaseResult(false, "该角色被其他账户引用！！！");
        }
        return roleService.deleteRole(Long.valueOf(roleId)) > 0 ? new BaseResult(true, "删除角色成功！！！") : new BaseResult(false, "删除角色失败！！！");
    }

    /**
     * 请求角色授权页面
     * type:add,delete,edit,view,import,export,menu
     */
    @RequestMapping(value = "/toAuth")
    public ModelAndView toAuth(@RequestParam String roleId, @RequestParam String type) throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            List<MenuDTO> menuDTOList = new ArrayList<>();
            List<Menu> menuList = null;
            if ("menu".equals(type)) {
                menuList = menuService.getAllParentMenu();
            } else {
                menuList = menuService.getParentMenuByRoleId(Long.valueOf(roleId));
            }
            for (Menu menu : menuList) {
                MenuDTO menuDTO = new MenuDTO();
                BeanUtils.copyProperties(menu, menuDTO);
                menuDTO.setMenuId(menu.getMenuId().toString());
                menuDTO.setParentId(menu.getParentId().toString());

                List<Menu> subMenuList = null;
                if ("menu".equals(type)) {
                    subMenuList = menuService.getSubMenuByParentId(menu.getMenuId());
                } else {
                    subMenuList = menuService.getSubMenuByRoleIdAndParentId(Long.valueOf(roleId), menu.getMenuId());
                }
                List<MenuDTO> subMenuDTOList = new ArrayList<>();
                boolean checkFlag = false;
                for (Menu subMenu : subMenuList) {
                    MenuDTO subMenuDTO = new MenuDTO();
                    subMenuDTO.setHasMenu(false);
                    BeanUtils.copyProperties(subMenu, subMenuDTO);
                    subMenuDTO.setMenuId(subMenu.getMenuId().toString());
                    subMenuDTO.setParentId(subMenu.getParentId().toString());

                    if ("menu".equals(type)) {
                        // 如果角色有该菜单（权限），就true
                        if (roleService.isHaveMenu(Long.valueOf(roleId), subMenu.getMenuId())) {
                            subMenuDTO.setHasMenu(true);
                            checkFlag = true;
                        }
                    } else {
                        RolePermission rolePermission = roleService.getRolePermissionByRoleIdAndMnuId(Long.valueOf(roleId), subMenu.getMenuId());
                        if ("add".equals(type)) {
                            // 如果角色有该菜单的新增权限，就true
                            if (null != rolePermission && rolePermission.getAddRights()) {
                                subMenuDTO.setHasMenu(true);
                                checkFlag = true;
                            }
                        } else if ("delete".equals(type)) {
                            // 如果角色有该菜单的删除权限，就true
                            if (null != rolePermission && rolePermission.getDeleteRights()) {
                                subMenuDTO.setHasMenu(true);
                                checkFlag = true;
                            }
                        } else if ("edit".equals(type)) {
                            // 如果角色有该菜单的新增权限，就true
                            if (null != rolePermission && rolePermission.getEditRights()) {
                                subMenuDTO.setHasMenu(true);
                                checkFlag = true;
                            }
                        } else if ("view".equals(type)) {
                            // 如果角色有该菜单的新增权限，就true
                            if (null != rolePermission && rolePermission.getViewRights()) {
                                subMenuDTO.setHasMenu(true);
                                checkFlag = true;
                            }
                        } else if ("import".equals(type)) {
                            // 如果角色有该菜单的新增权限，就true
                            if (null != rolePermission && rolePermission.getImportRights()) {
                                subMenuDTO.setHasMenu(true);
                                checkFlag = true;
                            }
                        } else if ("export".equals(type)) {
                            // 如果角色有该菜单的新增权限，就true
                            if (null != rolePermission && rolePermission.getExportRights()) {
                                checkFlag = true;
                                subMenuDTO.setHasMenu(true);
                            }
                        }
                    }
                    subMenuDTOList.add(subMenuDTO);
                }
                if (checkFlag) {
                    menuDTO.setHasMenu(true);
                }

                menuDTO.setSubMenu(subMenuDTOList);
                menuDTOList.add(menuDTO);
            }

            String json = JSON.toJSONString(menuDTOList);

            // 符合zTree的使用
            json = json.replaceAll("menuId", "id").replaceAll("menuName", "name").replaceAll("subMenu", "children").replaceAll("hasMenu", "checked").replace("parentId", "pId");
            mv.addObject("zTreeNodes", json);
            mv.addObject("roleId", roleId);
            mv.addObject("page", "role");
            mv.addObject("type", type);
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        mv.setViewName("system/role/authorization");
        return mv;
    }

    /**
     * 角色权限
     * type:add,delete,edit,view,import,export,menu
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object auth() throws Exception {
        Map requestMap = this.getParameterMapByPost();
        Long roleId = null == requestMap.get("roleId") ? null : Long.valueOf(DecodeUtils.urlDecode(requestMap.get("roleId").toString()));
        String menuIds = null == requestMap.get("menuIds") ? null : DecodeUtils.urlDecode(requestMap.get("menuIds").toString());
        String type = null == requestMap.get("type") ? null : DecodeUtils.urlDecode(requestMap.get("type").toString());

        User user = (User) this.getSession().getAttribute(Const.SESSION_USER);

        List<RolePermission> rolePermissionList = new ArrayList<>();

        String[] menuIdList = menuIds.split(",");
        if ("menu".equals(type)) {
            for (String menuId : menuIdList) {
                RolePermission rolePermission = new RolePermission();
                Permission permission = permissionService.getPermissionByMenuId(Long.valueOf(menuId));
                RolePermission rolePermissionTemp = rolePermissionService.getRolePermissionByPermissionIdAndRoleId(permission.getPermissionId(), roleId);
                if (null != rolePermissionTemp) {
                    BeanUtils.copyProperties(rolePermissionTemp, rolePermission);
                } else {
                    rolePermission.setRolePermissionId(IdGeneratorUtils.getInstance().nextId());
                    rolePermission.setPermissionId(permission.getPermissionId());
                    rolePermission.setRoleId(roleId);
                    rolePermission.setAddRights(false);
                    rolePermission.setEditRights(false);
                    rolePermission.setDeleteRights(false);
                    rolePermission.setViewRights(false);
                    rolePermission.setImportRights(false);
                    rolePermission.setExportRights(false);
                    TableProperties.createProperties(rolePermission, user.getTrueName());
                }
                TableProperties.modifyProperties(rolePermission, user.getTrueName());
                rolePermissionList.add(rolePermission);
            }
        } else {
            rolePermissionList = rolePermissionService.getRolePermissionByRoleId(roleId);
            for (String menuId : menuIdList) {
                Permission permission = permissionService.getPermissionByMenuId(Long.valueOf(menuId));
                for (RolePermission rolePermission : rolePermissionList) {
                    if (permission.getPermissionId().equals(rolePermission.getPermissionId())) {
                        if ("add".equals(type)) {
                            rolePermission.setAddRights(true);
                        } else if ("delete".equals(type)) {
                            rolePermission.setDeleteRights(true);
                        } else if ("edit".equals(type)) {
                            rolePermission.setEditRights(true);
                        } else if ("view".equals(type)) {
                            rolePermission.setViewRights(true);
                        } else if ("import".equals(type)) {
                            rolePermission.setImportRights(true);
                        } else if ("export".equals(type)) {
                            rolePermission.setExportRights(true);
                        }
                        TableProperties.modifyProperties(rolePermission, user.getTrueName());
                        break;
                    }
                }
            }
        }
        return rolePermissionService.saveRolePermission(roleId, rolePermissionList) > 0 ? new BaseResult(true, "角色权限设置成功！！！") : new BaseResult(false, "角色权限设置失败！！！");

    }
}
