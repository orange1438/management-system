package indi.orange1438.managementsystem.web.system.menu;

import com.alibaba.fastjson.JSON;
import indi.orange1438.managementsystem.dao.entity.Menu;
import indi.orange1438.managementsystem.dao.entity.Permission;
import indi.orange1438.managementsystem.dao.entity.PermissionMenu;
import indi.orange1438.managementsystem.dao.entity.User;
import indi.orange1438.managementsystem.dto.BaseResult;
import indi.orange1438.managementsystem.dto.MenuDTO;
import indi.orange1438.managementsystem.dto.RolePermissionMenuDTO;
import indi.orange1438.managementsystem.service.system.MenuService;
import indi.orange1438.managementsystem.service.system.PermissionService;
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
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/07 22:42
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {

    @Resource(name = "menuService")
    private MenuService menuService;

    @Resource(name = "permissionService")
    private PermissionService permissionService;

    /**
     * 显示菜单列表
     */
    @RequestMapping
    public ModelAndView list() throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            List<Menu> menuList = menuService.getAllParentMenu();
            mv.addObject("menuList", menuList);

            Map rolePermissionMenuMap = (Map) this.getSession().getAttribute(Const.SESSION_ROLE_PERMISSION);
            mv.addObject("permission", rolePermissionMenuMap.get(Const.PERMISSION_MENU));

            mv.setViewName("system/menu/menu_list");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 获取当前菜单的所有子菜单
     *
     * @param menuId
     */
    @RequestMapping(value = "/sub", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getSubMenu(@RequestParam String menuId) throws Exception {
        List<Menu> subMenu = menuService.getSubMenuByParentId(Long.valueOf(menuId));
        List<MenuDTO> menuDTOList = new ArrayList<>();
        for (Menu menu : subMenu) {
            MenuDTO menuDTO = new MenuDTO();
            BeanUtils.copyProperties(menu, menuDTO);
            menuDTO.setMenuId(menu.getMenuId().toString());
            menuDTOList.add(menuDTO);
        }
        return JSON.toJSONString(menuDTOList);
    }

    /**
     * 请求编辑菜单图标页面
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/toEditIcon")
    public ModelAndView toEditIconPage(String menuId) throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            mv.addObject("menuId", menuId);
            mv.setViewName("system/menu/menu_icon");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 保存菜单图标 (顶部菜单)
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/editIcon")
    @ResponseBody
    public Object editicon() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        String menuId = null == requestMap.get("menuId") ? null : requestMap.get("menuId").toString();
        String menuIcon = null == requestMap.get("menuIcon") ? null : requestMap.get("menuIcon").toString();
        if (null == menuId) {
            return new BaseResult(false, "菜单ID不能为空！");
        }
        Menu menu = new Menu();
        menu.setMenuId(Long.valueOf(menuId));
        menu.setMenuIcon(menuIcon);
        User user = (User) this.getSession().getAttribute(Const.SESSION_USER);
        TableProperties.modifyProperties(menu, user.getTrueName());
        return menuService.updateMenuByMenuId(menu) > 0 ? new BaseResult(true, "修改菜单图标成功！") : new BaseResult(false, "修改菜单图标失败");
    }

    /**
     * 请求编辑菜单页面
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/toEdit")
    public ModelAndView toEditPage(String menuId) throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            if (null == menuId) {
                throw new Exception("menuId Null");
            }
            Menu menu = menuService.getMenuByMenuId(Long.valueOf(menuId));
            List<Menu> menuList = menuService.getAllParentMenu();
            mv.addObject("menuList", menuList);
            mv.addObject("menu", menu);
            mv.setViewName("system/menu/menu_edit");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 保存编辑
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public Object edit() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        String menuId = null == requestMap.get("MENU_ID") ? null : DecodeUtils.urlDecode(requestMap.get("MENU_ID").toString());
        String menuOrder = null == requestMap.get("MENU_ORDER") ? null : requestMap.get("MENU_ORDER").toString();
        String menuName = null == requestMap.get("MENU_NAME") ? null : DecodeUtils.urlDecode(requestMap.get("MENU_NAME").toString());
        String parentId = null == requestMap.get("PARENT_ID") ? null : DecodeUtils.urlDecode(requestMap.get("PARENT_ID").toString());
        String menuUrl = null == requestMap.get("MENU_URL") ? null : DecodeUtils.urlDecode(requestMap.get("MENU_URL").toString());
        String menuType = null == requestMap.get("MENU_TYPE") ? null : requestMap.get("MENU_TYPE").toString();

        Menu menu = new Menu();
        menu.setMenuId(Long.valueOf(menuId));
        menu.setMenuOrder(Integer.valueOf(menuOrder));
        menu.setMenuName(menuName);
        menu.setParentId(Long.valueOf(parentId));
        menu.setMenuUrl(menuUrl);
        menu.setMenuType(menuType);
        if (!"0".equals(parentId)) {
            //处理菜单类型====
            Menu parentMenu = menuService.getMenuByParentId(menu.getParentId());
            if (null != parentMenu) {
                menu.setMenuType(parentMenu.getMenuType());
            }
        }
        User user = (User) this.getSession().getAttribute(Const.SESSION_USER);
        TableProperties.modifyProperties(menu, user.getTrueName());
        return menuService.updateMenuByMenuId(menu) > 0 ? new BaseResult(true, "修改菜单成功！") : new BaseResult(false, "修改菜单失败");
    }

    /**
     * 删除菜单
     *
     * @param menuId
     */
    @RequestMapping(value = "/del")
    @ResponseBody
    public Object delete(@RequestParam String menuId) throws Exception {
        // 如果权限被角色使用，则提示
        if (permissionService.isHaveRoleByMenuId(Long.valueOf(menuId))) {
            return new BaseResult(false, "菜单被其他角色使用！！！");
        }
        if (menuService.deleteMenuById(Long.valueOf(menuId)) > 0) {
            return new BaseResult(true, "删除菜单成功");
        }
        return new BaseResult(false, "删除菜单失败");
    }

    /**
     * 请求新增菜单页面
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public ModelAndView toAddPage() throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            List<Menu> menuList = menuService.getAllParentMenu();
            mv.addObject("menuList", menuList);
            mv.setViewName("system/menu/menu_add");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 保存菜单信息
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object add() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        String menuOrder = null == requestMap.get("MENU_ORDER") ? null : DecodeUtils.urlDecode(requestMap.get("MENU_ORDER").toString());
        String menuName = null == requestMap.get("MENU_NAME") ? null : DecodeUtils.urlDecode(requestMap.get("MENU_NAME").toString());
        String parentId = null == requestMap.get("PARENT_ID") ? null : DecodeUtils.urlDecode(requestMap.get("PARENT_ID").toString());
        String menuUrl = null == requestMap.get("MENU_URL") ? null : DecodeUtils.urlDecode(requestMap.get("MENU_URL").toString());
        String menuType = null == requestMap.get("MENU_TYPE") ? null : DecodeUtils.urlDecode(requestMap.get("MENU_TYPE").toString());

        Menu menu = new Menu();
        menu.setMenuId(IdGeneratorUtils.getInstance().nextId());
        menu.setMenuOrder(Integer.valueOf(menuOrder));
        menu.setMenuName(menuName);
        menu.setParentId(Long.valueOf(parentId));
        menu.setMenuUrl(menuUrl);
        menu.setMenuIcon("icon-desktop");
        menu.setMenuType(menuType);
        if (!"0".equals(parentId)) {
            //处理菜单类型====
            Menu parentMenu = menuService.getMenuByParentId(menu.getParentId());
            if (null != parentMenu) {
                menu.setMenuType(parentMenu.getMenuType());
            }
        }
        User user = (User) this.getSession().getAttribute(Const.SESSION_USER);
        TableProperties.createProperties(menu, user.getTrueName());
        TableProperties.createProperties(menu, user.getTrueName());

        // 权限表
        Permission permission = new Permission();
        permission.setPermissionId(IdGeneratorUtils.getInstance().nextId());
        permission.setDescription(menu.getMenuName());
        permission.setPermissionName(menu.getMenuName());
        TableProperties.createProperties(permission, user.getTrueName());
        TableProperties.modifyProperties(permission, user.getTrueName());

        // 权限菜单表
        PermissionMenu permissionMenu = new PermissionMenu();
        permissionMenu.setPermissionMenuId(IdGeneratorUtils.getInstance().nextId());
        permissionMenu.setMenuId(menu.getMenuId());
        permissionMenu.setPermissionId(permission.getPermissionId());
        TableProperties.createProperties(permissionMenu, user.getTrueName());
        TableProperties.modifyProperties(permissionMenu, user.getTrueName());

        return menuService.insertMenu(menu, permission, permissionMenu) > 0 ? new BaseResult(true, "新增菜单成功！") : new BaseResult(false, "新增菜单失败");
    }

}
