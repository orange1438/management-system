package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.PermissionDAO;
import indi.orange1438.managementsystem.dao.RolePermissionDAO;
import indi.orange1438.managementsystem.dao.entity.Permission;
import indi.orange1438.managementsystem.dao.entity.RolePermission;
import indi.orange1438.managementsystem.dao.entity.RolePermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限服务类
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/21 22:06
 */
@Service
public class PermissionService {

    @Autowired
    PermissionDAO permissionDAO;

    @Autowired
    RolePermissionDAO rolePermissionDAO;

    /**
     * 通过menuId得到对应的权限
     */
    public Permission getPermissionByMenuId(Long menuId) throws Exception {
        List<Permission> permissionList = permissionDAO.getPermissionByMenuId(menuId);
        if (null != permissionList && 0 < permissionList.size()) {
            return permissionList.get(0);
        }
        return null;
    }

    /**
     * 通过menuId得到对应的权限,并判断是否被角色使用
     */
    public boolean isHaveRoleByMenuId(Long menuId) throws Exception {
        List<Permission> permissionList = permissionDAO.getPermissionByMenuId(menuId);
        if (null != permissionList && 0 < permissionList.size()) {
            Permission permission = permissionList.get(0);
            RolePermissionExample rolePermissionExample = new RolePermissionExample();
            rolePermissionExample.createCriteria().andPermissionIdEqualTo(permission.getPermissionId());
            List<RolePermission> rolePermissionList = rolePermissionDAO.selectByExample(rolePermissionExample);
            if (null != rolePermissionList && rolePermissionList.size() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 通过组Id得到权限点
     */
    public List<Permission> getPermissionByGroupId(Long groupId) throws Exception {
        return permissionDAO.getPermissionByGroupId(groupId);
    }
}
