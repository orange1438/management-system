package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.RoleDAO;
import indi.orange1438.managementsystem.dao.RoleGroupDAO;
import indi.orange1438.managementsystem.dao.RolePermissionDAO;
import indi.orange1438.managementsystem.dao.UserRoleDAO;
import indi.orange1438.managementsystem.dao.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色服务
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/16 9:22
 */
@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    RoleGroupDAO roleGroupDAO;

    @Autowired
    UserRoleDAO userRoleDAO;

    @Autowired
    RolePermissionDAO rolePermissionDAO;

    /**
     * 通过 userId 得到当前角色
     */
    public Role getRoleByUserId(Long userId) throws Exception {
        return roleDAO.getRoleByUserId(userId);
    }

    /**
     * 通过groupId 得到当前组下的角色
     */
    public List<Role> getRoleByGroupId(Long groupId) throws Exception {
        return roleDAO.getRoleByGroupId(groupId);
    }

    /**
     * 插入角色以及角色组信息
     *
     * @return
     */
    public int insertRole(Role role, RoleGroup roleGroup, List<RolePermission> rolePermissionList) {
        rolePermissionDAO.insertBatchSelective(rolePermissionList);
        roleDAO.insertSelective(role);
        return roleGroupDAO.insertSelective(roleGroup);
    }

    /**
     * 通过roleId 得到角色
     */
    public Role getRoleByRoleId(Long roleId) throws Exception {
        return roleDAO.selectByPrimaryKey(roleId);
    }

    /**
     * 更新角色
     *
     * @param role 必须包含主键
     */
    public int updateRoleByRoleId(Role role) throws Exception {
        return roleDAO.updateByPrimaryKeySelective(role);
    }

    /**
     * 删除角色
     *
     * @param roleId 必须主键
     */
    public int deleteRole(Long roleId) throws Exception {
        // sys_role、sys_role_group、sys_role_permission;
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionDAO.deleteByExample(rolePermissionExample);

        RoleGroupExample roleGroupExample = new RoleGroupExample();
        roleGroupExample.createCriteria().andRoleIdEqualTo(roleId);
        roleGroupDAO.deleteByExample(roleGroupExample);
        return roleDAO.deleteByPrimaryKey(roleId);
    }

    /**
     * 该角色是否有该菜单
     *
     * @return
     */
    public Boolean isHaveMenu(Long roleId, Long menuId) {
        List<RolePermission> rolePermissionList = rolePermissionDAO.isHaveMenu(roleId, menuId);
        if (null != rolePermissionList && rolePermissionList.size() > 0) return true;
        return false;
    }

    /**
     * 得到角色指定菜单
     *
     * @return
     */
    public RolePermission getRolePermissionByRoleIdAndMnuId(Long roleId, Long menuId) {
        List<RolePermission> rolePermissionList = rolePermissionDAO.isHaveMenu(roleId, menuId);
        if (null != rolePermissionList && rolePermissionList.size() > 0) return rolePermissionList.get(0);
        return null;
    }

    /**
     * 得到所有角色
     */
    public List<Role> getAllRole() throws Exception {
        return roleDAO.selectByExample(null);
    }

    /**
     * 通过roleId判断该角色是否被用户引用
     */
    public boolean isHaveRoleByroleId(List roleIdList) throws Exception {
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andRoleIdIn(roleIdList);
        List<UserRole> userRoleList = userRoleDAO.selectByExample(userRoleExample);
        if (null != userRoleList && userRoleList.size() > 0) {
            return true;
        }
        return false;
    }
}
