package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.MenuDAO;
import indi.orange1438.managementsystem.dao.entity.Menu;
import indi.orange1438.managementsystem.dao.entity.MenuExample;
import indi.orange1438.managementsystem.dto.MenuDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 通过role MENU_RIGHTS得到用户对应权限下的菜单
     *
     * @param userId
     * @return
     */
    public List<MenuDTO> getMenuDTOByUserId(Long userId) throws Exception {
        List<MenuDTO> parentMenuDTOList = menuDAO.getParentMenuByUserId(userId);
        for (MenuDTO menuDTO : parentMenuDTOList) {
            List<MenuDTO> subMenuDTOList = menuDAO.getSubMenuByUserIdAndParentId(userId, menuDTO.getMenuId());
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
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criterion1 = menuExample.createCriteria();
        criterion1.andMenuIdEqualTo(menuId);

        MenuExample.Criteria criterion2 = menuExample.createCriteria();
        criterion2.andParentIdEqualTo(menuId);
        menuExample.or(criterion2);
        return menuDAO.deleteByExample(menuExample);
    }

    /**
     * 保存菜单
     *
     * @param menu 保存的实体类，必须包括主键
     */
    public int saveMenu(Menu menu) throws Exception {
        return menuDAO.insertSelective(menu);
    }
}
