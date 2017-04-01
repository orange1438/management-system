package indi.orange1438.managementsystem.dto;

import indi.orange1438.managementsystem.dao.entity.User;

/**
 * 用户角色
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/29 14:42
 */
public class UserRoleDTO extends User {
    // 角色ID
    private Long roleId;

    // 角色名
    private String roleName;

    // 角色描述
    private String description;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
