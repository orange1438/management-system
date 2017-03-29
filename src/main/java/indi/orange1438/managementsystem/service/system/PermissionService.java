package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.PermissionDAO;
import indi.orange1438.managementsystem.dao.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
