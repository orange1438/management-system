package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.RoleGroupDAO;
import indi.orange1438.managementsystem.dao.entity.RoleGroup;
import indi.orange1438.managementsystem.dao.entity.RoleGroupExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色组
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/31 13:52
 */
@Service
public class RoleGroupService {

    @Autowired
    RoleGroupDAO roleGroupDAO;

    /**
     * 通过组ID，得到角色组
     *
     * @param groupId
     * @return
     * @throws Exception
     */
    public List<RoleGroup> getRoleGroupByGroupId(Long groupId) throws Exception {
        RoleGroupExample roleGroupExample = new RoleGroupExample();
        roleGroupExample.createCriteria().andGroupIdEqualTo(groupId);
        return roleGroupDAO.selectByExample(roleGroupExample);
    }
}
