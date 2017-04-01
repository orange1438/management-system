package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.RolePermissionDAO;
import indi.orange1438.managementsystem.dao.entity.RolePermission;
import indi.orange1438.managementsystem.dao.entity.RolePermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色权限服务类
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/28 15:08
 */
@Service
public class RolePermissionService {

    @Autowired
    RolePermissionDAO rolePermissionDAO;


    /**
     * 如果在role_permission存在权限点，就更新，否则新建
     */
    public int saveRolePermission(List<RolePermission> rolePermissions) throws Exception {
        int flag = 0;
        for (RolePermission rolePermission : rolePermissions) {
            flag++;
            if (null != rolePermission.getPermissionId()) {
                RolePermissionExample rolePermissionExample = new RolePermissionExample();
                rolePermissionExample.createCriteria().andPermissionIdEqualTo(rolePermission.getPermissionId());
                List<RolePermission> rolePermissionList = rolePermissionDAO.selectByExample(rolePermissionExample);
                if (null != rolePermissionList && rolePermissionList.size() > 0) {
                    // 存在
                    rolePermission.setCreateTime(null);
                    rolePermission.setCreator(null);
                    rolePermission.setRolePermissionId(rolePermissionList.get(0).getRolePermissionId());
                    rolePermissionDAO.updateByPrimaryKeySelective(rolePermission);
                }
            } else {
                // 不存在
                rolePermissionDAO.insertSelective(rolePermission);
            }
        }
        return flag == rolePermissions.size() ? 1 : 0;
    }
}
