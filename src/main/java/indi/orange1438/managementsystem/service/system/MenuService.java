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
     * 通过用户ID得到用户对应权限下的菜单
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
}
