/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao;

import indi.orange1438.managementsystem.dao.entity.Permission;
import indi.orange1438.managementsystem.dao.entity.PermissionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 */
@Repository
public interface PermissionDAO extends IMapper<Permission, PermissionExample, Long> {

    /**
     * 通过menuId得到对应的权限
     *
     * @param menuId
     * @return
     */
    List<Permission> getPermissionByMenuId(@Param("menuId") Long menuId);
}