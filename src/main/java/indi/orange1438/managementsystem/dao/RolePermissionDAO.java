/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao;

import indi.orange1438.managementsystem.dao.entity.RolePermission;
import indi.orange1438.managementsystem.dao.entity.RolePermissionExample;
import indi.orange1438.managementsystem.dto.RolePermissionMenuDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本文件由 mybatis-generator-1.3.5 自动生成
 * @author orange1438 code generator
 */
@Repository
public interface RolePermissionDAO extends IMapper<RolePermission, RolePermissionExample, Long> {

    /**
     * 指定角色是否拥有指定的菜单ID
     *
     * @param roleId 角色ID
     * @param menuId 菜单ID
     * @return
     */
    List<RolePermission> isHaveMenu(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    /**
     * 通过用户id 得到角色权限菜单
     *
     * @param userId
     * @return
     */
    List<RolePermissionMenuDTO> getRolePermissionMenuDTOByUserId(@Param("userId") Long userId);
}