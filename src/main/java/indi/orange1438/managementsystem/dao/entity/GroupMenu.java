/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 组与菜单的关联表 sys_group_menu
 *
 * @author orange1438 code generator
 */
public class GroupMenu implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 6397472545736730293L;

    // 组与菜单关系ID
    private Long groupMenuId;

    // 菜单ID
    private Long menuId;

    // 组ID
    private Long groupId;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creater;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /**
     * 获取 组与菜单关系ID sys_group_menu.GROUP_MENU_ID
     *
     * @return 组与菜单关系ID
     */
    public Long getGroupMenuId() {
        return groupMenuId;
    }

    /**
     * 设置 组与菜单关系ID sys_group_menu.GROUP_MENU_ID
     *
     * @param groupMenuId 组与菜单关系ID
     */
    public void setGroupMenuId(Long groupMenuId) {
        this.groupMenuId = groupMenuId;
    }

    /**
     * 获取 菜单ID sys_group_menu.MENU_ID
     *
     * @return 菜单ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置 菜单ID sys_group_menu.MENU_ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取 组ID sys_group_menu.GROUP_ID
     *
     * @return 组ID
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置 组ID sys_group_menu.GROUP_ID
     *
     * @param groupId 组ID
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取 创建时间 sys_group_menu.CREATE_TIME
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 sys_group_menu.CREATE_TIME
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建人 sys_group_menu.CREATER
     *
     * @return 创建人
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置 创建人 sys_group_menu.CREATER
     *
     * @param creater 创建人
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 获取 修改时间 sys_group_menu.MODIFY_TIME
     *
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置 修改时间 sys_group_menu.MODIFY_TIME
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取 修改人 sys_group_menu.MODIFIER
     *
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置 修改人 sys_group_menu.MODIFIER
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
        sb.append(", groupMenuId=").append(groupMenuId);
        sb.append(", menuId=").append(menuId);
        sb.append(", groupId=").append(groupId);
        sb.append(", createTime=").append(createTime);
        sb.append(", creater=").append(creater);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}