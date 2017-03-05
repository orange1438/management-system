/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限点许可表 sys_permission
 *
 * @author orange1438 code generator
 */
public class Permission implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 8203522144097109857L;

    // 权限ID
    private Long permissionId;

    // 权限名
    private String permissionName;

    // 权限描述
    private String description;

    // 添加权限:1表示能，0表示不能  默认：1
    private Boolean addRights;

    // ADD标题
    private String addTitle;

    // 删除权限:1表示能，0表示不能  默认：1
    private Boolean deleteRights;

    // DELETE标题
    private String deleteTitle;

    // 编辑权限:1表示能，0表示不能  默认：1
    private Boolean editRights;

    // EDIT标题
    private String editTitle;

    // 查看权限:1表示能，0表示不能  默认：1
    private Boolean viewRights;

    // VIEW标题
    private String viewTitle;

    // 导入权限:1表示能，0表示不能  默认：1
    private Boolean importRights;

    // IMPORT标题
    private String importTitle;

    // 导出权限:1表示能，0表示不能  默认：1
    private Boolean exportRights;

    // EXPORT标题
    private String exportTitle;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creater;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /**
     * 获取 权限ID sys_permission.PERMISSION_ID
     *
     * @return 权限ID
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 设置 权限ID sys_permission.PERMISSION_ID
     *
     * @param permissionId 权限ID
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取 权限名 sys_permission.PERMISSION_NAME
     *
     * @return 权限名
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 设置 权限名 sys_permission.PERMISSION_NAME
     *
     * @param permissionName 权限名
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 获取 权限描述 sys_permission.DESCRIPTION
     *
     * @return 权限描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 权限描述 sys_permission.DESCRIPTION
     *
     * @param description 权限描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取 添加权限:1表示能，0表示不能 sys_permission.ADD_RIGHTS
     *
     * @return 添加权限:1表示能，0表示不能
     */
    public Boolean getAddRights() {
        return addRights;
    }

    /**
     * 设置 添加权限:1表示能，0表示不能 sys_permission.ADD_RIGHTS
     *
     * @param addRights 添加权限:1表示能，0表示不能
     */
    public void setAddRights(Boolean addRights) {
        this.addRights = addRights;
    }

    /**
     * 获取 ADD标题 sys_permission.ADD_TITLE
     *
     * @return ADD标题
     */
    public String getAddTitle() {
        return addTitle;
    }

    /**
     * 设置 ADD标题 sys_permission.ADD_TITLE
     *
     * @param addTitle ADD标题
     */
    public void setAddTitle(String addTitle) {
        this.addTitle = addTitle == null ? null : addTitle.trim();
    }

    /**
     * 获取 删除权限:1表示能，0表示不能 sys_permission.DELETE_RIGHTS
     *
     * @return 删除权限:1表示能，0表示不能
     */
    public Boolean getDeleteRights() {
        return deleteRights;
    }

    /**
     * 设置 删除权限:1表示能，0表示不能 sys_permission.DELETE_RIGHTS
     *
     * @param deleteRights 删除权限:1表示能，0表示不能
     */
    public void setDeleteRights(Boolean deleteRights) {
        this.deleteRights = deleteRights;
    }

    /**
     * 获取 DELETE标题 sys_permission.DELETE_TITLE
     *
     * @return DELETE标题
     */
    public String getDeleteTitle() {
        return deleteTitle;
    }

    /**
     * 设置 DELETE标题 sys_permission.DELETE_TITLE
     *
     * @param deleteTitle DELETE标题
     */
    public void setDeleteTitle(String deleteTitle) {
        this.deleteTitle = deleteTitle == null ? null : deleteTitle.trim();
    }

    /**
     * 获取 编辑权限:1表示能，0表示不能 sys_permission.EDIT_RIGHTS
     *
     * @return 编辑权限:1表示能，0表示不能
     */
    public Boolean getEditRights() {
        return editRights;
    }

    /**
     * 设置 编辑权限:1表示能，0表示不能 sys_permission.EDIT_RIGHTS
     *
     * @param editRights 编辑权限:1表示能，0表示不能
     */
    public void setEditRights(Boolean editRights) {
        this.editRights = editRights;
    }

    /**
     * 获取 EDIT标题 sys_permission.EDIT_TITLE
     *
     * @return EDIT标题
     */
    public String getEditTitle() {
        return editTitle;
    }

    /**
     * 设置 EDIT标题 sys_permission.EDIT_TITLE
     *
     * @param editTitle EDIT标题
     */
    public void setEditTitle(String editTitle) {
        this.editTitle = editTitle == null ? null : editTitle.trim();
    }

    /**
     * 获取 查看权限:1表示能，0表示不能 sys_permission.VIEW_RIGHTS
     *
     * @return 查看权限:1表示能，0表示不能
     */
    public Boolean getViewRights() {
        return viewRights;
    }

    /**
     * 设置 查看权限:1表示能，0表示不能 sys_permission.VIEW_RIGHTS
     *
     * @param viewRights 查看权限:1表示能，0表示不能
     */
    public void setViewRights(Boolean viewRights) {
        this.viewRights = viewRights;
    }

    /**
     * 获取 VIEW标题 sys_permission.VIEW_TITLE
     *
     * @return VIEW标题
     */
    public String getViewTitle() {
        return viewTitle;
    }

    /**
     * 设置 VIEW标题 sys_permission.VIEW_TITLE
     *
     * @param viewTitle VIEW标题
     */
    public void setViewTitle(String viewTitle) {
        this.viewTitle = viewTitle == null ? null : viewTitle.trim();
    }

    /**
     * 获取 导入权限:1表示能，0表示不能 sys_permission.IMPORT_RIGHTS
     *
     * @return 导入权限:1表示能，0表示不能
     */
    public Boolean getImportRights() {
        return importRights;
    }

    /**
     * 设置 导入权限:1表示能，0表示不能 sys_permission.IMPORT_RIGHTS
     *
     * @param importRights 导入权限:1表示能，0表示不能
     */
    public void setImportRights(Boolean importRights) {
        this.importRights = importRights;
    }

    /**
     * 获取 IMPORT标题 sys_permission.IMPORT_TITLE
     *
     * @return IMPORT标题
     */
    public String getImportTitle() {
        return importTitle;
    }

    /**
     * 设置 IMPORT标题 sys_permission.IMPORT_TITLE
     *
     * @param importTitle IMPORT标题
     */
    public void setImportTitle(String importTitle) {
        this.importTitle = importTitle == null ? null : importTitle.trim();
    }

    /**
     * 获取 导出权限:1表示能，0表示不能 sys_permission.EXPORT_RIGHTS
     *
     * @return 导出权限:1表示能，0表示不能
     */
    public Boolean getExportRights() {
        return exportRights;
    }

    /**
     * 设置 导出权限:1表示能，0表示不能 sys_permission.EXPORT_RIGHTS
     *
     * @param exportRights 导出权限:1表示能，0表示不能
     */
    public void setExportRights(Boolean exportRights) {
        this.exportRights = exportRights;
    }

    /**
     * 获取 EXPORT标题 sys_permission.EXPORT_TITLE
     *
     * @return EXPORT标题
     */
    public String getExportTitle() {
        return exportTitle;
    }

    /**
     * 设置 EXPORT标题 sys_permission.EXPORT_TITLE
     *
     * @param exportTitle EXPORT标题
     */
    public void setExportTitle(String exportTitle) {
        this.exportTitle = exportTitle == null ? null : exportTitle.trim();
    }

    /**
     * 获取 创建时间 sys_permission.CREATE_TIME
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 sys_permission.CREATE_TIME
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建人 sys_permission.CREATER
     *
     * @return 创建人
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置 创建人 sys_permission.CREATER
     *
     * @param creater 创建人
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 获取 修改时间 sys_permission.MODIFY_TIME
     *
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置 修改时间 sys_permission.MODIFY_TIME
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取 修改人 sys_permission.MODIFIER
     *
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置 修改人 sys_permission.MODIFIER
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
        sb.append(", permissionId=").append(permissionId);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", description=").append(description);
        sb.append(", addRights=").append(addRights);
        sb.append(", addTitle=").append(addTitle);
        sb.append(", deleteRights=").append(deleteRights);
        sb.append(", deleteTitle=").append(deleteTitle);
        sb.append(", editRights=").append(editRights);
        sb.append(", editTitle=").append(editTitle);
        sb.append(", viewRights=").append(viewRights);
        sb.append(", viewTitle=").append(viewTitle);
        sb.append(", importRights=").append(importRights);
        sb.append(", importTitle=").append(importTitle);
        sb.append(", exportRights=").append(exportRights);
        sb.append(", exportTitle=").append(exportTitle);
        sb.append(", createTime=").append(createTime);
        sb.append(", creater=").append(creater);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}