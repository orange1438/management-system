package indi.orange1438.managementsystem.web.system.role;

import indi.orange1438.managementsystem.dao.entity.Group;
import indi.orange1438.managementsystem.dao.entity.Role;
import indi.orange1438.managementsystem.dto.RolePermissionDTO;
import indi.orange1438.managementsystem.service.system.GroupService;
import indi.orange1438.managementsystem.service.system.RoleService;
import indi.orange1438.managementsystem.util.BeanUtils;
import indi.orange1438.managementsystem.web.system.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 角色、组
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


    /**
     * 列表
     */
    @RequestMapping
    public ModelAndView list() throws Exception {
        ModelAndView mv = this.getModelAndView();

        Map requestMap = this.getParameterMapByGet();
        String groupId = null == requestMap.get("groupId") ? "1" : requestMap.get("groupId").toString();
        Group currentGroup = groupService.getGroupByGroupId(Long.valueOf(groupId));    // 当前组

        List<Role> roleList = roleService.getRoleByGroupId(currentGroup.getGroupId());        //列出当前组的所有角色

        List<Group> groupList = groupService.getAllGroup();                //列出所有组(有时候可以是部门的概念)

        mv.addObject("currentGroup", currentGroup);
        mv.addObject("groupList", groupList);
        mv.addObject("roleList", roleList);
        mv.setViewName("system/role/role_list");

        return mv;
    }
}
