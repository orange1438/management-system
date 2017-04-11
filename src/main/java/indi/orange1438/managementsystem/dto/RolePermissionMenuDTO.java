package indi.orange1438.managementsystem.dto;

/**
 * 角色权限菜单
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/04/06 9:25
 */
public class RolePermissionMenuDTO {
    // 菜单ID
    private String menuId;

    // 菜单名称
    private String menuName;

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

    // 删除权限:1表示能，0表示不能  默认：1
    private Boolean deleteRights;

    // 编辑权限:1表示能，0表示不能  默认：1
    private Boolean editRights;

    // 详细权限:1表示能，0表示不能  默认：1
    private Boolean detailRights;

    // 导入权限:1表示能，0表示不能  默认：1
    private Boolean importRights;

    // 导出权限:1表示能，0表示不能  默认：1
    private Boolean exportRights;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

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

    public Boolean getDeleteRights() {
        return deleteRights;
    }

    public void setDeleteRights(Boolean deleteRights) {
        this.deleteRights = deleteRights;
    }

    public Boolean getEditRights() {
        return editRights;
    }

    public void setEditRights(Boolean editRights) {
        this.editRights = editRights;
    }

    public Boolean getDetailRights() {
        return detailRights;
    }

    public void setDetailRights(Boolean detailRights) {
        this.detailRights = detailRights;
    }

    public Boolean getImportRights() {
        return importRights;
    }

    public void setImportRights(Boolean importRights) {
        this.importRights = importRights;
    }

    public Boolean getExportRights() {
        return exportRights;
    }

    public void setExportRights(Boolean exportRights) {
        this.exportRights = exportRights;
    }
}
