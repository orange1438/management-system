/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * 用户角色关联表 sys_user_role
 * @author orange1438 code generator
 */
public class UserRole implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -3133271777414452657L;

    // 用户角色关系ID
    private Long userRoleId;

    // 角色ID
    private Long roleId;

    // 权限ID
    private Long userId;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creator;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    /** 
     * 获取 用户角色关系ID sys_user_role.USER_ROLE_ID
     * @return 用户角色关系ID
     */
    public Long getUserRoleId() {
        return userRoleId;
    }

    /** 
     * 设置 用户角色关系ID sys_user_role.USER_ROLE_ID
     * @param userRoleId 用户角色关系ID
     */
    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    /** 
     * 获取 角色ID sys_user_role.ROLE_ID
     * @return 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /** 
     * 设置 角色ID sys_user_role.ROLE_ID
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /** 
     * 获取 权限ID sys_user_role.USER_ID
     * @return 权限ID
     */
    public Long getUserId() {
        return userId;
    }

    /** 
     * 设置 权限ID sys_user_role.USER_ID
     * @param userId 权限ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
     * 获取 创建时间 sys_user_role.CREATE_TIME
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 sys_user_role.CREATE_TIME
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 创建人 sys_user_role.CREATOR
     * @return 创建人
     */
    public String getCreator() {
        return creator;
    }

    /** 
     * 设置 创建人 sys_user_role.CREATOR
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /** 
     * 获取 修改时间 sys_user_role.MODIFY_TIME
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /** 
     * 设置 修改时间 sys_user_role.MODIFY_TIME
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /** 
     * 获取 修改人 sys_user_role.MODIFIER
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /** 
     * 设置 修改人 sys_user_role.MODIFIER
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
        sb.append(", userRoleId=").append(userRoleId);
        sb.append(", roleId=").append(roleId);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}