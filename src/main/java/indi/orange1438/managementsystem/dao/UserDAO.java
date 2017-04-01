/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao;

import indi.orange1438.managementsystem.dao.entity.User;
import indi.orange1438.managementsystem.dao.entity.UserExample;
import indi.orange1438.managementsystem.dto.UserRoleDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 */
@Repository
public interface UserDAO extends IMapper<User, UserExample, Long> {

    /**
     * 根据Map条件查询用户,包含用户的角色
     */
    public List<UserRoleDTO> getUserByMap(Map requestMap);
}