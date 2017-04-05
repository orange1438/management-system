package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.MenuDAO;
import indi.orange1438.managementsystem.dao.PermissionDAO;
import indi.orange1438.managementsystem.dao.PermissionMenuDAO;
import indi.orange1438.managementsystem.dao.entity.*;
import indi.orange1438.managementsystem.dto.MenuDTO;
import indi.orange1438.managementsystem.util.IdGeneratorUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单服务类
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/05 22:10
 */
@Service
public class MenuService {

    @Autowired
    MenuDAO menuDAO;

    @Autowired
    PermissionDAO permissionDAO;

    @Autowired
    PermissionMenuDAO permissionMenuDAO;

    /**
     * 通过用户ID 得到用户对应权限下的菜单
     *
     * @param userId
     * @return
     */
    public List<MenuDTO> getMenuDTOByUserId(Long userId) throws Exception {
        List<MenuDTO> parentMenuDTOList = menuDAO.getParentMenuByUserId(userId);
        for (MenuDTO menuDTO : parentMenuDTOList) {
            List<MenuDTO> subMenuDTOList = menuDAO.getSubMenuByUserIdAndParentId(userId, Long.valueOf(menuDTO.getMenuId()));
            menuDTO.setSubMenu(subMenuDTOList);
            menuDTO.setHasMenu(true);
        }
        return parentMenuDTOList;
    }

    /**
     * 得到所有父级菜单
     *
     * @return
     */
    public List<Menu> getAllParentMenu() throws Exception {
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andParentIdEqualTo(0L);
        menuExample.setOrderByClause("MENU_ORDER");
        return menuDAO.selectByExample(menuExample);
    }

    /**
     * 得到当前父级菜单的子菜单
     *
     * @return
     */
    public List<Menu> getSubMenuByParentId(Long parentId) throws Exception {
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andParentIdEqualTo(parentId);
        menuExample.setOrderByClause("MENU_ORDER");
        return menuDAO.selectByExample(menuExample);
    }

    /**
     * 通过父级ID得到父级菜单
     *
     * @param parentId
     */
    public Menu getMenuByParentId(Long parentId) throws Exception {
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andMenuIdEqualTo(parentId);
        menuExample.setOrderByClause("MENU_ORDER");
        List<Menu> menuList = menuDAO.selectByExample(menuExample);
        if (null != menuList && 0 < menuList.size()) {
            return menuList.get(0);
        }
        return null;
    }

    /**
     * 得到 roleId 拥有菜单的父级菜单
     *
     * @return
     */
    public List<Menu> getParentMenuByRoleId(Long roleId) throws Exception {
        return menuDAO.getParentMenuByRoleId(roleId);
    }

    /**
     * 得到 roleId 的父级菜单的子菜单
     *
     * @return
     */
    public List<Menu> getSubMenuByRoleIdAndParentId(Long roleId, Long parentId) throws Exception {
        return menuDAO.getSubMenuByRoleIdAndParentId(roleId, parentId);
    }

    /**
     * 更新菜单信息
     *
     * @param menu 要更新的实体类，必须包括主键
     */
    public int updateMenuByMenuId(Menu menu) throws Exception {
        return menuDAO.updateByPrimaryKeySelective(menu);
    }

    /**
     * 通过 MenuId 得到菜单
     */
    public Menu getMenuByMenuId(Long menuId) throws Exception {
        return menuDAO.selectByPrimaryKey(menuId);
    }

    /**
     * 通过 MenuId 删除菜单,以及对应的子菜单
     */
    public int deleteMenuById(Long menuId) throws Exception {
        // sys_menu、sys_permission、sys_permission_menu
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criterion1 = menuExample.createCriteria();
        criterion1.andMenuIdEqualTo(menuId);

        MenuExample.Criteria criterion2 = menuExample.createCriteria();
        criterion2.andParentIdEqualTo(menuId);
        menuExample.or(criterion2);

        List<Long> menuIdList = new ArrayList<>();
        List<Menu> menuList = menuDAO.selectByExample(menuExample);
        for (Menu menu : menuList) {
            menuIdList.add(menu.getMenuId());
        }

        PermissionMenuExample permissionMenuExample = new PermissionMenuExample();
        permissionMenuExample.createCriteria().andMenuIdIn(menuIdList);

        List<PermissionMenu> permissionMenus = permissionMenuDAO.selectByExample(permissionMenuExample);
        for (PermissionMenu permissionMenu : permissionMenus) {
            permissionDAO.deleteByPrimaryKey(permissionMenu.getPermissionId());
        }
        permissionMenuDAO.deleteByExample(permissionMenuExample);

        return menuDAO.deleteByExample(menuExample);
    }

    /**
     * 添加菜单
     *
     * @param menu 添加的实体类，必须包括主键
     */
    public int insertMenu(Menu menu, Permission permission, PermissionMenu permissionMenu) throws Exception {
        // sys_menu、sys_permission、sys_permission_menu
        permissionDAO.insertSelective(permission);
        permissionMenuDAO.insertSelective(permissionMenu);
        return menuDAO.insertSelective(menu);
    }

    /**
     * 通过组ID得到组下的菜单
     *
     * @param groupId
     * @return
     */
    public List<Menu> getMenuByGroupId(Long groupId) {
        return menuDAO.getMenuByGroupId(groupId);
    }

    /**
     * 组ID 是否拥有 menuId的菜单
     *
     * @return
     */
    public Boolean isHaveMenu(Long groupId, Long menuId) {
        List<Menu> menuList = menuDAO.isHaveMenu(groupId, menuId);
        if (null != menuId && menuList.size() > 0) return true;
        return false;
    }

}
