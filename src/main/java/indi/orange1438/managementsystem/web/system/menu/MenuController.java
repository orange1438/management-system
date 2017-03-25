package indi.orange1438.managementsystem.web.system.menu;

import com.alibaba.fastjson.JSON;
import indi.orange1438.managementsystem.dao.entity.Menu;
import indi.orange1438.managementsystem.service.system.MenuService;
import indi.orange1438.managementsystem.util.IdGeneratorUtils;
import indi.orange1438.managementsystem.util.SecurityUtils.DecodeUtils;
import indi.orange1438.managementsystem.util.StringUtils;
import indi.orange1438.managementsystem.web.system.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
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
        Map requestMap = this.getParameterMapByPost();
        String menuId = null == requestMap.get("menuId") ? null : requestMap.get("menuId").toString();
        String menuIcon = null == requestMap.get("menuIcon") ? null : requestMap.get("menuIcon").toString();
        if (null == menuId) {
            return -1;
        }
        Menu menu = new Menu();
        menu.setMenuId(Long.valueOf(menuId));
        menu.setMenuIcon(menuIcon);
        return menuService.updateMenuByMenuId(menu) > 0 ? 1 : 0;
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
        Map requestMap = this.getParameterMapByPost();
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
        return menuService.updateMenuByMenuId(menu);
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @param out
     */
    @RequestMapping(value = "/del")
    public void delete(@RequestParam String menuId, PrintWriter out) throws Exception {
        try {
            if (menuService.deleteMenuById(Long.valueOf(menuId)) > 0) {
                out.write("success");
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
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
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add() throws Exception {
        Map requestMap = this.getParameterMapByPost();
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
        menu.setMenuType(menuType);
        if (!"0".equals(parentId)) {
            //处理菜单类型====
            Menu parentMenu = menuService.getMenuByParentId(menu.getParentId());
            if (null != parentMenu) {
                menu.setMenuType(parentMenu.getMenuType());
            }
        }
        return menuService.saveMenu(menu);
    }

}
