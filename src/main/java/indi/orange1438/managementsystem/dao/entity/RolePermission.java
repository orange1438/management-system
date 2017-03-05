/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限关联表 sys_role_permission
 *
 * @author orange1438 code generator
 */
public class RolePermission implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -1800850767775948253L;

    // 角色权限关系ID
    private Long rolePermissionId;

    // 角色ID
    private Long roleId;

    // 权限ID
    private Long permissionId;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creater;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /**
     * 获取 角色权限关系ID sys_role_permission.ROLE_PERMISSION_ID
     *
     * @return 角色权限关系ID
     */
    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    /**
     * 设置 角色权限关系ID sys_role_permission.ROLE_PERMISSION_ID
     *
     * @param rolePermissionId 角色权限关系ID
     */
    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    /**
     * 获取 角色ID sys_role_permission.ROLE_ID
     *
     * @return 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置 角色ID sys_role_permission.ROLE_ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取 权限ID sys_role_permission.PERMISSION_ID
     *
     * @return 权限ID
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置 权限ID sys_role_permission.PERMISSION_ID
     *
     * @param permissionId 权限ID
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取 创建时间 sys_role_permission.CREATE_TIME
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 sys_role_permission.CREATE_TIME
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建人 sys_role_permission.CREATER
     *
     * @return 创建人
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置 创建人 sys_role_permission.CREATER
     *
     * @param creater 创建人
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 获取 修改时间 sys_role_permission.MODIFY_TIME
     *
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置 修改时间 sys_role_permission.MODIFY_TIME
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取 修改人 sys_role_permission.MODIFIER
     *
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置 修改人 sys_role_permission.MODIFIER
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", rolePermissionId=").append(rolePermissionId);
        sb.append(", roleId=").append(roleId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", createTime=").append(createTime);
        sb.append(", creater=").append(creater);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}