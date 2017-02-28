package indi.orange1438.managementsystem.interceptor;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 * Shiro登录和权限认证
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/27 18:25
 */
public class ShiroRealm extends AuthorizingRealm {

    /*
    shiro异常：
        DisabledAccountException （禁用的帐号）
        LockedAccountException （锁定的帐号）
        UnknownAccountException（错误的帐号）
        ExcessiveAttemptsException（登录失败次数过多）
        IncorrectCredentialsException （错误的凭证）
        ExpiredCredentialsException （过期的凭证）
     */

    /**
     * 登录信息和用户验证信息验证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        return new SimpleAuthenticationInfo(token.getUsername(), new String(token.getPassword()), getName());
    }

    /**
     * 授权查询回调函数
     * 行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
