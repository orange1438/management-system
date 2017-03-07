package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.MenuDAO;
import indi.orange1438.managementsystem.dao.entity.Menu;
import indi.orange1438.managementsystem.dto.MenuDTO;
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

    /**
     * 通过用户ID得到用户对应权限下的菜单
     *
     * @param userId
     * @return
     */
    public List<MenuDTO> getMenuDTOByUserId(Long userId) {
        List<MenuDTO> parentMenuDTOList = menuDAO.getParentMenuByUserId(userId);
        for (MenuDTO menuDTO : parentMenuDTOList) {
            List<MenuDTO> subMenuDTOList = menuDAO.getSubMenuByUserIdAndParentId(userId, menuDTO.getMenuId());
            menuDTO.setSubMenu(subMenuDTOList);
            menuDTO.setHasMenu(true);
        }
        return parentMenuDTOList;
    }
}
