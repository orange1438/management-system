/* https://github.com/orange1438 */
package indi.orange1438.managementsystem.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -4199807253573689142L;

    // 用户ID
    private Long userId;

    // 账户名
    private String userName;

    // 账户密码
    private String password;

    // 是否禁用  默认：0
    private String isDisabled;

    // 父级账号ID
    private Long parentId;

    // 真实姓名
    private String trueName;

    // 手机号
    private String mobile;

    // 电子邮箱
    private String email;

    // 上次登录时间
    private Date lastLoginTime;

    // 登录IP（支持IPV4、IPV6）
    private String loginIp;

    // 登录次数  默认：0
    private Long loginCount;

    // 创建时间  默认：CURRENT_TIMESTAMP
    private Date createTime;

    // 创建人
    private String creater;

    // 修改时间  默认：CURRENT_TIMESTAMP
    private Date modifyTime;

    // 修改人
    private String modifier;

    // xxxxx
    private byte[] xxxxx;

    /**
     * 获取 用户ID sys_user.USER_ID
     *
     * @return 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 用户ID sys_user.USER_ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取 账户名 sys_user.USER_NAME
     *
     * @return 账户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 账户名 sys_user.USER_NAME
     *
     * @param userName 账户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 账户密码 sys_user.PASSWORD
     *
     * @return 账户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 账户密码 sys_user.PASSWORD
     *
     * @param password 账户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取 是否禁用 sys_user.IS_DISABLED
     *
     * @return 是否禁用
     */
    public String getIsDisabled() {
        return isDisabled;
    }

    /**
     * 设置 是否禁用 sys_user.IS_DISABLED
     *
     * @param isDisabled 是否禁用
     */
    public void setIsDisabled(String isDisabled) {
        this.isDisabled = isDisabled == null ? null : isDisabled.trim();
    }

    /**
     * 获取 父级账号ID sys_user.PARENT_ID
     *
     * @return 父级账号ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置 父级账号ID sys_user.PARENT_ID
     *
     * @param parentId 父级账号ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取 真实姓名 sys_user.TRUE_NAME
     *
     * @return 真实姓名
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 设置 真实姓名 sys_user.TRUE_NAME
     *
     * @param trueName 真实姓名
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    /**
     * 获取 手机号 sys_user.MOBILE
     *
     * @return 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置 手机号 sys_user.MOBILE
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 电子邮箱 sys_user.EMAIL
     *
     * @return 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 电子邮箱 sys_user.EMAIL
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取 上次登录时间 sys_user.LAST_LOGIN_TIME
     *
     * @return 上次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置 上次登录时间 sys_user.LAST_LOGIN_TIME
     *
     * @param lastLoginTime 上次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取 登录IP（支持IPV4、IPV6） sys_user.LOGIN_IP
     *
     * @return 登录IP（支持IPV4、IPV6）
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置 登录IP（支持IPV4、IPV6） sys_user.LOGIN_IP
     *
     * @param loginIp 登录IP（支持IPV4、IPV6）
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 获取 登录次数 sys_user.LOGIN_COUNT
     *
     * @return 登录次数
     */
    public Long getLoginCount() {
        return loginCount;
    }

    /**
     * 设置 登录次数 sys_user.LOGIN_COUNT
     *
     * @param loginCount 登录次数
     */
    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 获取 创建时间 sys_user.CREATE_TIME
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 sys_user.CREATE_TIME
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建人 sys_user.CREATER
     *
     * @return 创建人
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置 创建人 sys_user.CREATER
     *
     * @param creater 创建人
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * 获取 修改时间 sys_user.MODIFY_TIME
     *
     * @return 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置 修改时间 sys_user.MODIFY_TIME
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取 修改人 sys_user.MODIFIER
     *
     * @return 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置 修改人 sys_user.MODIFIER
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 获取 xxxxx sys_user.xxxxx
     *
     * @return xxxxx
     */
    public byte[] getXxxxx() {
        return xxxxx;
    }

    /**
     * 设置 xxxxx sys_user.xxxxx
     *
     * @param xxxxx xxxxx
     */
    public void setXxxxx(byte[] xxxxx) {
        this.xxxxx = xxxxx;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", isDisabled=").append(isDisabled);
        sb.append(", parentId=").append(parentId);
        sb.append(", trueName=").append(trueName);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginCount=").append(loginCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", creater=").append(creater);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", xxxxx=").append(xxxxx);
        sb.append("]");
        return sb.toString();
    }
}