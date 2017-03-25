/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao;

import indi.orange1438.managementsystem.dao.entity.Menu;
import indi.orange1438.managementsystem.dao.entity.MenuExample;
import indi.orange1438.managementsystem.dto.MenuDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438 code generator
 */
@Repository
public interface MenuDAO extends IMapper<Menu, MenuExample, Long> {
    /**
     * 通过用户ID得到用户对应权限下的父级菜单
     *
     * @param userId
     * @return
     */
    List<MenuDTO> getParentMenuByUserId(Long userId);

    /**
     * 通过用户ID和父级ID得到用子菜单
     *
     * @param userId
     * @param parentId
     * @return
     */
    List<MenuDTO> getSubMenuByUserIdAndParentId(@Param("userId") Long userId,
                                                @Param("parentId") Long parentId);
}