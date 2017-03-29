package indi.orange1438.managementsystem.web.system.role;

import com.alibaba.fastjson.JSON;
import indi.orange1438.managementsystem.dao.entity.Group;
import indi.orange1438.managementsystem.dao.entity.GroupMenu;
import indi.orange1438.managementsystem.dao.entity.Menu;
import indi.orange1438.managementsystem.dao.entity.User;
import indi.orange1438.managementsystem.dto.MenuDTO;
import indi.orange1438.managementsystem.service.system.GroupMenuService;
import indi.orange1438.managementsystem.service.system.GroupService;
import indi.orange1438.managementsystem.service.system.MenuService;
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
 * 角色组
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/25 22:20
 */
@Controller
@RequestMapping(value = "/group")
public class GroupController extends BaseController {

    @Resource(name = "menuService")
    private MenuService menuService;

    @Resource(name = "groupService")
    private GroupService groupService;

    @Resource(name = "groupMenuService")
    private GroupMenuService groupMenuService;

    /**
     * 新增组页面
     */
    @RequestMapping(value = "/toAdd")
    public ModelAndView toAdd() throws Exception {
        ModelAndView mv = this.getModelAndView();

        try {
            Map requestMap = this.getParameterMapByGet();
            requestMap.put("action", "/group/add.do");
            requestMap.put("name", "组");
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
        String parentId = null == requestMap.get("parentId") ? null : DecodeUtils.urlDecode(requestMap.get("parentId").toString());
        String groupName = null == requestMap.get("Name") ? null : DecodeUtils.urlDecode(requestMap.get("Name").toString());
        String description = null == requestMap.get("Description") ? null : DecodeUtils.urlDecode(requestMap.get("Description").toString());

        Group group = new Group();
        group.setDescription(description);
        group.setGroupId(IdGeneratorUtils.getInstance().nextId());
        group.setParentId(Long.valueOf(parentId));
        group.setGroupName(groupName);

        User user = (User) this.getSession().getAttribute(Const.SESSION_USER);
        TableProperties.createProperties(group, user.getTrueName());
        TableProperties.modifyProperties(group, user.getTrueName());

        return groupService.insertGroup(group);
    }

    /**
     * 编辑组页面
     */
    @RequestMapping(value = "/toEdit")
    public ModelAndView toEdit() throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            Map requestMap = this.getParameterMapByGet();
            String groupId = null == requestMap.get("groupId") ? null : DecodeUtils.urlDecode(requestMap.get("groupId").toString());
            Group group = groupService.getGroupByGroupId(Long.valueOf(groupId));
            mv.addObject("group", group);

            requestMap.put("action", "/group/edit.do");
            requestMap.put("name", "组");
            mv.addObject("page", requestMap);
            mv.setViewName("system/role/page_edit");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 编辑组接口
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object edit() throws Exception {
        Map requestMap = this.getParameterMapByJsonPost();
        String groupId = null == requestMap.get("groupId") ? null : DecodeUtils.urlDecode(requestMap.get("groupId").toString());
        String groupName = null == requestMap.get("Name") ? null : DecodeUtils.urlDecode(requestMap.get("Name").toString());
        String description = null == requestMap.get("Description") ? null : DecodeUtils.urlDecode(requestMap.get("Description").toString());

        Group group = new Group();
        group.setDescription(description);
        group.setGroupId(Long.valueOf(groupId));
        group.setGroupName(groupName);

        User user = (User) this.getSession().getAttribute(Const.SESSION_USER);
        TableProperties.modifyProperties(group, user.getTrueName());

        return groupService.updateGroup(group);
    }

    /**
     * 删除组
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object delete(@RequestParam String groupId) throws Exception {
        return groupService.deleteGroup(Long.valueOf(groupId));
    }

    /**
     * 请求组菜单授权页面
     */
    @RequestMapping(value = "/toAuth")
    public ModelAndView toAuth(@RequestParam String groupId) throws Exception {
        ModelAndView mv = this.getModelAndView();
        try {
            List<Menu> menuList = menuService.getAllParentMenu();
            List<MenuDTO> menuDTOList = new ArrayList<>();
            for (Menu menu : menuList) {
                MenuDTO menuDTO = new MenuDTO();
                BeanUtils.copyProperties(menu, menuDTO);
                menuDTO.setMenuId(menu.getMenuId().toString());
                menuDTO.setParentId(menu.getParentId().toString());

                List<Menu> subMenuList = menuService.getSubMenuByParentId(menu.getMenuId());
                List<MenuDTO> subMenuDTOList = new ArrayList<>();
                for (Menu subMenu : subMenuList) {
                    MenuDTO subMenuDTO = new MenuDTO();
                    BeanUtils.copyProperties(subMenu, subMenuDTO);
                    subMenuDTO.setMenuId(subMenu.getMenuId().toString());
                    subMenuDTO.setParentId(subMenu.getParentId().toString());

                    // 如果当前组有该菜单，就true
                    subMenuDTO.setHasMenu(false);
                    if (menuService.isHaveMenu(Long.valueOf(groupId), subMenu.getMenuId())) {
                        subMenuDTO.setHasMenu(true);
                    }
                    subMenuDTOList.add(subMenuDTO);
                }

                menuDTO.setSubMenu(subMenuDTOList);
                menuDTOList.add(menuDTO);
            }
            String json = JSON.toJSONString(menuDTOList);

            // 符合zTree的使用
            json = json.replaceAll("menuId", "id").replaceAll("menuName", "name").replaceAll("subMenu", "nodes").replaceAll("hasMenu", "checked");
            mv.addObject("zTreeNodes", json);
            mv.addObject("groupId", groupId);
            mv.addObject("page", "group");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        mv.setViewName("system/role/authorization");
        return mv;
    }

    /**
     * 组菜单权限
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object auth() throws Exception {
        Map requestMap = this.getParameterMapByPost();
        String groupId = null == requestMap.get("groupId") ? null : DecodeUtils.urlDecode(requestMap.get("groupId").toString());
        String menuIds = null == requestMap.get("menuIds") ? null : DecodeUtils.urlDecode(requestMap.get("menuIds").toString());

        User user = (User) this.getSession().getAttribute(Const.SESSION_USER);

        List<GroupMenu> groupMenuList = new ArrayList<>();
        String[] menuIdList = menuIds.split(",");
        for (String menuId : menuIdList) {
            GroupMenu groupMenu = new GroupMenu();
            groupMenu.setGroupMenuId(IdGeneratorUtils.getInstance().nextId());
            groupMenu.setMenuId(Long.valueOf(menuId));
            groupMenu.setGroupId(Long.valueOf(groupId));
            TableProperties.createProperties(groupMenu, user.getTrueName());
            TableProperties.modifyProperties(groupMenu, user.getTrueName());
            groupMenuList.add(groupMenu);
        }
        return groupMenuService.insertGroupMenu(Long.valueOf(groupId), groupMenuList);
    }
}
