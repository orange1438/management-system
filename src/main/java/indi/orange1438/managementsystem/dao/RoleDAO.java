/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao;

import indi.orange1438.managementsystem.dao.entity.Role;
import indi.orange1438.managementsystem.dao.entity.RoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 */
@Repository
public interface RoleDAO extends IMapper<Role, RoleExample, Long> {

    /**
     * 通过groupId 得到当前组下的角色
     */
    List<Role> getRoleByGroupId(@Param("groupId") Long groupId);
}