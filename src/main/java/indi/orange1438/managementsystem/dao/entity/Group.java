/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * 组表 sys_group
 * @author orange1438 code generator
 */
public class Group implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = 8784696498949885008L;

    // 组ID
    private Long groupId;

    // 组名
    private String groupName;

    // 组描述
    private String description;

    // 父组ID
    private Long parentId;

    // 菜单权限(拥有哪些菜单)
    private String menuRights;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creator;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /** 
     * 获取 组ID sys_group.GROUP_ID
     * @return 组ID
     */
    public Long getGroupId() {
        return groupId;
    }

    /** 
     * 设置 组ID sys_group.GROUP_ID
     * @param groupId 组ID
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /** 
     * 获取 组名 sys_group.GROUP_NAME
     * @return 组名
     */
    public String getGroupName() {
        return groupName;
    }

    /** 
     * 设置 组名 sys_group.GROUP_NAME
     * @param groupName 组名
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /** 
     * 获取 组描述 sys_group.DESCRIPTION
     * @return 组描述
     */
    public String getDescription() {
        return description;
    }

    /** 
     * 设置 组描述 sys_group.DESCRIPTION
     * @param description 组描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /** 
     * 获取 父组ID sys_group.PARENT_ID
     * @return 父组ID
     */
    public Long getParentId() {
        return parentId;
    }

    /** 
     * 设置 父组ID sys_group.PARENT_ID
     * @param parentId 父组ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取 菜单权限(拥有哪些菜单) sys_group.MENU_RIGHTS
     *
     * @return 菜单权限(拥有哪些菜单)
     */
    public String getMenuRights() {
        return menuRights;
    }

    /**
     * 设置 菜单权限(拥有哪些菜单) sys_group.MENU_RIGHTS
     *
     * @param menuRights 菜单权限(拥有哪些菜单)
     */
    public void setMenuRights(String menuRights) {
        this.menuRights = menuRights == null ? null : menuRights.trim();
    }

    /** 
     * 获取 创建时间 sys_group.CREATE_TIME
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sys_group.CREATE_TIME
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建人 sys_group.CREATOR
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置 创建人 sys_group.CREATOR
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /** 
     * 获取 修改时间 sys_group.MODIFY_TIME
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /** 
     * 设置 修改时间 sys_group.MODIFY_TIME
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /** 
     * 获取 修改人 sys_group.MODIFIER
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /** 
     * 设置 修改人 sys_group.MODIFIER
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
        sb.append(", groupId=").append(groupId);
        sb.append(", groupName=").append(groupName);
        sb.append(", description=").append(description);
        sb.append(", parentId=").append(parentId);
        sb.append(", menuRights=").append(menuRights);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}