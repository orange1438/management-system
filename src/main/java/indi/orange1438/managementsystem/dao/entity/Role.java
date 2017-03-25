/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * 角色表 sys_role
 * @author orange1438 code generator
 */
public class Role implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -450376199996392640L;

    // 角色ID
    private Long roleId;

    // 角色名
    private String roleName;

    // 角色描述
    private String description;

    // 菜单权限
    private String menuRights;

    // 添加权限
    private String addRights;

    // 删除权限
    private String deleteRights;

    // 编辑权限
    private String editRights;

    // 查看详细权限
    private String viewRights;

    // 导入权限
    private String importRights;

    // 导出权限
    private String exportRights;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creator;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /** 
     * 获取 角色ID sys_role.ROLE_ID
     * @return 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /** 
     * 设置 角色ID sys_role.ROLE_ID
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /** 
     * 获取 角色名 sys_role.ROLE_NAME
     * @return 角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /** 
     * 设置 角色名 sys_role.ROLE_NAME
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /** 
     * 获取 角色描述 sys_role.DESCRIPTION
     * @return 角色描述
     */
    public String getDescription() {
        return description;
    }

    /** 
     * 设置 角色描述 sys_role.DESCRIPTION
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取 菜单权限 sys_role.MENU_RIGHTS
     *
     * @return 菜单权限
     */
    public String getMenuRights() {
        return menuRights;
    }

    /**
     * 设置 菜单权限 sys_role.MENU_RIGHTS
     *
     * @param menuRights 菜单权限
     */
    public void setMenuRights(String menuRights) {
        this.menuRights = menuRights == null ? null : menuRights.trim();
    }

    /**
     * 获取 添加权限 sys_role.ADD_RIGHTS
     *
     * @return 添加权限
     */
    public String getAddRights() {
        return addRights;
    }

    /**
     * 设置 添加权限 sys_role.ADD_RIGHTS
     *
     * @param addRights 添加权限
     */
    public void setAddRights(String addRights) {
        this.addRights = addRights == null ? null : addRights.trim();
    }

    /**
     * 获取 删除权限 sys_role.DELETE_RIGHTS
     *
     * @return 删除权限
     */
    public String getDeleteRights() {
        return deleteRights;
    }

    /**
     * 设置 删除权限 sys_role.DELETE_RIGHTS
     *
     * @param deleteRights 删除权限
     */
    public void setDeleteRights(String deleteRights) {
        this.deleteRights = deleteRights == null ? null : deleteRights.trim();
    }

    /**
     * 获取 编辑权限 sys_role.EDIT_RIGHTS
     *
     * @return 编辑权限
     */
    public String getEditRights() {
        return editRights;
    }

    /**
     * 设置 编辑权限 sys_role.EDIT_RIGHTS
     *
     * @param editRights 编辑权限
     */
    public void setEditRights(String editRights) {
        this.editRights = editRights == null ? null : editRights.trim();
    }

    /**
     * 获取 查看详细权限 sys_role.VIEW_RIGHTS
     *
     * @return 查看详细权限
     */
    public String getViewRights() {
        return viewRights;
    }

    /**
     * 设置 查看详细权限 sys_role.VIEW_RIGHTS
     *
     * @param viewRights 查看详细权限
     */
    public void setViewRights(String viewRights) {
        this.viewRights = viewRights == null ? null : viewRights.trim();
    }

    /**
     * 获取 导入权限 sys_role.IMPORT_RIGHTS
     *
     * @return 导入权限
     */
    public String getImportRights() {
        return importRights;
    }

    /**
     * 设置 导入权限 sys_role.IMPORT_RIGHTS
     *
     * @param importRights 导入权限
     */
    public void setImportRights(String importRights) {
        this.importRights = importRights == null ? null : importRights.trim();
    }

    /**
     * 获取 导出权限 sys_role.EXPORT_RIGHTS
     *
     * @return 导出权限
     */
    public String getExportRights() {
        return exportRights;
    }

    /**
     * 设置 导出权限 sys_role.EXPORT_RIGHTS
     *
     * @param exportRights 导出权限
     */
    public void setExportRights(String exportRights) {
        this.exportRights = exportRights == null ? null : exportRights.trim();
    }

    /** 
     * 获取 创建时间 sys_role.CREATE_TIME
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sys_role.CREATE_TIME
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建人 sys_role.CREATOR
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置 创建人 sys_role.CREATOR
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /** 
     * 获取 修改时间 sys_role.MODIFY_TIME
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /** 
     * 设置 修改时间 sys_role.MODIFY_TIME
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /** 
     * 获取 修改人 sys_role.MODIFIER
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /** 
     * 设置 修改人 sys_role.MODIFIER
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
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", description=").append(description);
        sb.append(", menuRights=").append(menuRights);
        sb.append(", addRights=").append(addRights);
        sb.append(", deleteRights=").append(deleteRights);
        sb.append(", editRights=").append(editRights);
        sb.append(", viewRights=").append(viewRights);
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