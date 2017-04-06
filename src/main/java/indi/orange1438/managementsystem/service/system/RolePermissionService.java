package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.RolePermissionDAO;
import indi.orange1438.managementsystem.dao.entity.RolePermission;
import indi.orange1438.managementsystem.dao.entity.RolePermissionExample;
import indi.orange1438.managementsystem.dto.RolePermissionMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 如果在role_permission存在权限点，先删，再新建
     */
    public int saveRolePermission(Long roleId, List<RolePermission> rolePermissions) throws Exception {

        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionDAO.deleteByExample(rolePermissionExample);
        int flag = 0;
        for (RolePermission rolePermission : rolePermissions) {
            flag++;
            rolePermissionDAO.insertSelective(rolePermission);
        }
        return flag == rolePermissions.size() ? 1 : 0;
    }

    /**
     * 通过权限ID\角色id 得到角色权限
     */
    public RolePermission getRolePermissionByPermissionIdAndRoleId(Long permissionId, Long roleId) throws Exception {
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andPermissionIdEqualTo(permissionId).andRoleIdEqualTo(roleId);
        List<RolePermission> rolePermissionList = rolePermissionDAO.selectByExample(rolePermissionExample);
        if (null != rolePermissionList && rolePermissionList.size() > 0) {
            return rolePermissionList.get(0);
        }
        return null;
    }

    /**
     * 通过角色id 得到角色权限
     */
    public List<RolePermission> getRolePermissionByRoleId(Long roleId) throws Exception {
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RolePermission> rolePermissionList = rolePermissionDAO.selectByExample(rolePermissionExample);
        if (null != rolePermissionList && rolePermissionList.size() > 0) {
            return rolePermissionList;
        }
        return null;
    }

    /**
     * 通过用户id 得到角色权限菜单
     */
    public Map getRolePermissionMenuDTOByUserId(Long userId) throws Exception {
        List<RolePermissionMenuDTO> rolePermissionMenuDTOList = rolePermissionDAO.getRolePermissionMenuDTOByUserId(userId);
        Map<String, Object> map = new HashMap<String, Object>();
        for (RolePermissionMenuDTO rolePermissionMenuDTO : rolePermissionMenuDTOList) {
            map.put(rolePermissionMenuDTO.getMenuId(), rolePermissionMenuDTO);
        }
        return map;
    }
}
