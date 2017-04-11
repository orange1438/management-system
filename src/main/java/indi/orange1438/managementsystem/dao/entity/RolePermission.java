package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * 角色权限表 sys_role_permission
 * @author orange1438 code generator
 */
public class RolePermission implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 7811661878843274522L;

    // 权限ID
    private Long rolePermissionId;

    // 角色ID
    private Long roleId;

    // 权限ID
    private Long permissionId;

    // 添加权限:1表示能，0表示不能  默认：0
    private Boolean addRights;

    // 删除权限:1表示能，0表示不能  默认：0
    private Boolean deleteRights;

    // 编辑权限:1表示能，0表示不能  默认：0
    private Boolean editRights;

    // 详细权限:1表示能，0表示不能  默认：0
    private Boolean detailRights;

    // 导入权限:1表示能，0表示不能  默认：0
    private Boolean importRights;

    // 导出权限:1表示能，0表示不能  默认：0
    private Boolean exportRights;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creator;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /** 
     * 获取 权限ID sys_role_permission.ROLE_PERMISSION_ID
     * @return 权限ID
     */
    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    /** 
     * 设置 权限ID sys_role_permission.ROLE_PERMISSION_ID
     * @param rolePermissionId 权限ID
     */
    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    /** 
     * 获取 角色ID sys_role_permission.ROLE_ID
     * @return 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /** 
     * 设置 角色ID sys_role_permission.ROLE_ID
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /** 
     * 获取 权限ID sys_role_permission.PERMISSION_ID
     * @return 权限ID
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /** 
     * 设置 权限ID sys_role_permission.PERMISSION_ID
     * @param permissionId 权限ID
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /** 
     * 获取 添加权限:1表示能，0表示不能 sys_role_permission.ADD_RIGHTS
     * @return 添加权限:1表示能，0表示不能
     */
    public Boolean getAddRights() {
        return addRights;
    }

    /** 
     * 设置 添加权限:1表示能，0表示不能 sys_role_permission.ADD_RIGHTS
     * @param addRights 添加权限:1表示能，0表示不能
     */
    public void setAddRights(Boolean addRights) {
        this.addRights = addRights;
    }

    /** 
     * 获取 删除权限:1表示能，0表示不能 sys_role_permission.DELETE_RIGHTS
     * @return 删除权限:1表示能，0表示不能
     */
    public Boolean getDeleteRights() {
        return deleteRights;
    }

    /** 
     * 设置 删除权限:1表示能，0表示不能 sys_role_permission.DELETE_RIGHTS
     * @param deleteRights 删除权限:1表示能，0表示不能
     */
    public void setDeleteRights(Boolean deleteRights) {
        this.deleteRights = deleteRights;
    }

    /** 
     * 获取 编辑权限:1表示能，0表示不能 sys_role_permission.EDIT_RIGHTS
     * @return 编辑权限:1表示能，0表示不能
     */
    public Boolean getEditRights() {
        return editRights;
    }

    /** 
     * 设置 编辑权限:1表示能，0表示不能 sys_role_permission.EDIT_RIGHTS
     * @param editRights 编辑权限:1表示能，0表示不能
     */
    public void setEditRights(Boolean editRights) {
        this.editRights = editRights;
    }

    /**
     * 获取 详细权限:1表示能，0表示不能 sys_role_permission.DETAIL_RIGHTS
     * @return 详细权限:1表示能，0表示不能
     */
    public Boolean getDetailRights() {
        return detailRights;
    }

    /**
     * 设置 详细权限:1表示能，0表示不能 sys_role_permission.DETAIL_RIGHTS
     * @param detailRights 详细权限:1表示能，0表示不能
     */
    public void setDetailRights(Boolean detailRights) {
        this.detailRights = detailRights;
    }

    /** 
     * 获取 导入权限:1表示能，0表示不能 sys_role_permission.IMPORT_RIGHTS
     * @return 导入权限:1表示能，0表示不能
     */
    public Boolean getImportRights() {
        return importRights;
    }

    /** 
     * 设置 导入权限:1表示能，0表示不能 sys_role_permission.IMPORT_RIGHTS
     * @param importRights 导入权限:1表示能，0表示不能
     */
    public void setImportRights(Boolean importRights) {
        this.importRights = importRights;
    }

    /** 
     * 获取 导出权限:1表示能，0表示不能 sys_role_permission.EXPORT_RIGHTS
     * @return 导出权限:1表示能，0表示不能
     */
    public Boolean getExportRights() {
        return exportRights;
    }

    /** 
     * 设置 导出权限:1表示能，0表示不能 sys_role_permission.EXPORT_RIGHTS
     * @param exportRights 导出权限:1表示能，0表示不能
     */
    public void setExportRights(Boolean exportRights) {
        this.exportRights = exportRights;
    }

    /** 
     * 获取 创建时间 sys_role_permission.CREATE_TIME
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sys_role_permission.CREATE_TIME
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 创建人 sys_role_permission.CREATOR
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /** 
     * 设置 创建人 sys_role_permission.CREATOR
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /** 
     * 获取 修改时间 sys_role_permission.MODIFY_TIME
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /** 
     * 设置 修改时间 sys_role_permission.MODIFY_TIME
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /** 
     * 获取 修改人 sys_role_permission.MODIFIER
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /** 
     * 设置 修改人 sys_role_permission.MODIFIER
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
        sb.append(", addRights=").append(addRights);
        sb.append(", deleteRights=").append(deleteRights);
        sb.append(", editRights=").append(editRights);
        sb.append(", detailRights=").append(detailRights);
        sb.append(", importRights=").append(importRights);
        sb.append(", exportRights=").append(exportRights);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}