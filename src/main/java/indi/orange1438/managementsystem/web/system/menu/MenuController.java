package indi.orange1438.managementsystem.web.system.menu;

import com.alibaba.fastjson.JSON;
import indi.orange1438.managementsystem.dao.entity.Menu;
import indi.orange1438.managementsystem.service.system.MenuService;
import indi.orange1438.managementsystem.web.system.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

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

    /**
     * 显示菜单列表
     */
    @RequestMapping
    public ModelAndView list() throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            List<Menu> menuList = menuService.getAllParentMenu();
            mv.addObject("menuList", menuList);
            mv.setViewName("system/menu/menu_list");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 获取当前菜单的所有子菜单
     *
     * @param response
     * @param menuId
     */
    @RequestMapping(value = "/sub")
    public void getSubMenu(HttpServletResponse response, @RequestParam String menuId) throws Exception {
        try {
            List<Menu> subMenu = menuService.getSubMenuByParentId(Long.valueOf(menuId));
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            String json = JSON.toJSONString(subMenu);
            out.write(json);
            out.flush();
            out.close();
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
    }
}
