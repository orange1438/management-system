/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * 权限菜单关联表 sys_permission_menu
 * @author orange1438 code generator
 */
public class PermissionMenu implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -6496559204570534969L;

    // 权限菜单关系ID
    private Long permissionMenuId;

    // 权限ID
    private Long permissionId;

    // 菜单ID
    private Long menuId;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creator;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /** 
     * 获取 权限菜单关系ID sys_permission_menu.PERMISSION_MENU_ID
     * @return 权限菜单关系ID
     */
    public Long getPermissionMenuId() {
        return permissionMenuId;
    }

    /** 
     * 设置 权限菜单关系ID sys_permission_menu.PERMISSION_MENU_ID
     * @param permissionMenuId 权限菜单关系ID
     */
    public void setPermissionMenuId(Long permissionMenuId) {
        this.permissionMenuId = permissionMenuId;
    }

    /** 
     * 获取 权限ID sys_permission_menu.PERMISSION_ID
     * @return 权限ID
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /** 
     * 设置 权限ID sys_permission_menu.PERMISSION_ID
     * @param permissionId 权限ID
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /** 
     * 获取 菜单ID sys_permission_menu.MENU_ID
     * @return 菜单ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /** 
     * 设置 菜单ID sys_permission_menu.MENU_ID
     * @param menuId 菜单ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /** 
     * 获取 创建时间 sys_permission_menu.CREATE_TIME
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sys_permission_menu.CREATE_TIME
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 创建人 sys_permission_menu.CREATOR
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /** 
     * 设置 创建人 sys_permission_menu.CREATOR
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /** 
     * 获取 修改时间 sys_permission_menu.MODIFY_TIME
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /** 
     * 设置 修改时间 sys_permission_menu.MODIFY_TIME
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /** 
     * 获取 修改人 sys_permission_menu.MODIFIER
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /** 
     * 设置 修改人 sys_permission_menu.MODIFIER
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
        sb.append(", permissionMenuId=").append(permissionMenuId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", menuId=").append(menuId);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}