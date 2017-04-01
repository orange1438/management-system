package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.UserRoleDAO;
import indi.orange1438.managementsystem.dao.entity.UserRole;
import indi.orange1438.managementsystem.dao.entity.UserRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色服务
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/30 16:51
 */
@Service
public class UserRoleService {

    @Autowired
    UserRoleDAO userRoleDAO;

    /**
     * 通过userId 得到 用户角色
     *
     * @param userId
     */
    public UserRole getUserRoleByUserId(Long userId) throws Exception {
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId);
        List<UserRole> userRoleList = userRoleDAO.selectByExample(userRoleExample);
        if (null != userRoleList && 0 < userRoleList.size()) {
            return userRoleList.get(0);
        }
        return null;
    }
}
