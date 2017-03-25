package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.RoleDAO;
import indi.orange1438.managementsystem.dao.entity.Role;
import indi.orange1438.managementsystem.dao.entity.RoleExample;
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


}
