package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.MenuDAO;
import indi.orange1438.managementsystem.dao.entity.Menu;
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
    public List<Menu> getMenuByUserId(Long userId) {
        return menuDAO.getMenuByUserId(userId);
    }
}
