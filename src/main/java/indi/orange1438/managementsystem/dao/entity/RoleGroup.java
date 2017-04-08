/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * 角色与组的关联表 sys_role_group
 * @author orange1438 code generator
 */
public class RoleGroup implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -8240138169477218997L;

    // 角色组关系ID
    private Long roleGroupId;

    // 角色ID
    private Long roleId;

    // 组ID
    private Long groupId;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creator;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /** 
     * 获取 角色组关系ID sys_role_group.ROLE_GROUP_ID
     * @return 角色组关系ID
     */
    public Long getRoleGroupId() {
        return roleGroupId;
    }

    /** 
     * 设置 角色组关系ID sys_role_group.ROLE_GROUP_ID
     * @param roleGroupId 角色组关系ID
     */
    public void setRoleGroupId(Long roleGroupId) {
        this.roleGroupId = roleGroupId;
    }

    /** 
     * 获取 角色ID sys_role_group.ROLE_ID
     * @return 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /** 
     * 设置 角色ID sys_role_group.ROLE_ID
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /** 
     * 获取 组ID sys_role_group.GROUP_ID
     * @return 组ID
     */
    public Long getGroupId() {
        return groupId;
    }

    /** 
     * 设置 组ID sys_role_group.GROUP_ID
     * @param groupId 组ID
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /** 
     * 获取 创建时间 sys_role_group.CREATE_TIME
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sys_role_group.CREATE_TIME
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 创建人 sys_role_group.CREATOR
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /** 
     * 设置 创建人 sys_role_group.CREATOR
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /** 
     * 获取 修改时间 sys_role_group.MODIFY_TIME
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /** 
     * 设置 修改时间 sys_role_group.MODIFY_TIME
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /** 
     * 获取 修改人 sys_role_group.MODIFIER
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /** 
     * 设置 修改人 sys_role_group.MODIFIER
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
        sb.append(", roleGroupId=").append(roleGroupId);
        sb.append(", roleId=").append(roleId);
        sb.append(", groupId=").append(groupId);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}