package indi.orange1438.managementsystem.dto;

/**
 * 角色权限类
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/21 21:34
 */
public class RolePermissionDTO {
    // 角色ID
    private Long roleId;

    // 角色名
    private String roleName;

    // 权限ID
    private Long permissionId;

    // 权限名
    private String permissionName;

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

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Boolean getAddRights() {
        return addRights;
    }

    public void setAddRights(Boolean addRights) {
        this.addRights = addRights;
    }

    public String getAddTitle() {
        return addTitle;
    }

    public void setAddTitle(String addTitle) {
        this.addTitle = addTitle;
    }

    public Boolean getDeleteRights() {
        return deleteRights;
    }

    public void setDeleteRights(Boolean deleteRights) {
        this.deleteRights = deleteRights;
    }

    public String getDeleteTitle() {
        return deleteTitle;
    }

    public void setDeleteTitle(String deleteTitle) {
        this.deleteTitle = deleteTitle;
    }

    public Boolean getEditRights() {
        return editRights;
    }

    public void setEditRights(Boolean editRights) {
        this.editRights = editRights;
    }

    public String getEditTitle() {
        return editTitle;
    }

    public void setEditTitle(String editTitle) {
        this.editTitle = editTitle;
    }

    public Boolean getViewRights() {
        return viewRights;
    }

    public void setViewRights(Boolean viewRights) {
        this.viewRights = viewRights;
    }

    public String getViewTitle() {
        return viewTitle;
    }

    public void setViewTitle(String viewTitle) {
        this.viewTitle = viewTitle;
    }

    public Boolean getImportRights() {
        return importRights;
    }

    public void setImportRights(Boolean importRights) {
        this.importRights = importRights;
    }

    public String getImportTitle() {
        return importTitle;
    }

    public void setImportTitle(String importTitle) {
        this.importTitle = importTitle;
    }

    public Boolean getExportRights() {
        return exportRights;
    }

    public void setExportRights(Boolean exportRights) {
        this.exportRights = exportRights;
    }

    public String getExportTitle() {
        return exportTitle;
    }

    public void setExportTitle(String exportTitle) {
        this.exportTitle = exportTitle;
    }
}
