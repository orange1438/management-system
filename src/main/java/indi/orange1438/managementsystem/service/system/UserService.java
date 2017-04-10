package indi.orange1438.managementsystem.service.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import indi.orange1438.managementsystem.dao.UserDAO;
import indi.orange1438.managementsystem.dao.UserRoleDAO;
import indi.orange1438.managementsystem.dao.entity.User;
import indi.orange1438.managementsystem.dao.entity.UserExample;
import indi.orange1438.managementsystem.dao.entity.UserRole;
import indi.orange1438.managementsystem.dao.entity.UserRoleExample;
import indi.orange1438.managementsystem.dto.UserRoleDTO;
import indi.orange1438.managementsystem.util.SecurityUtils.DecodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户服务类
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/26 12:19
 */
@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserRoleDAO userRoleDAO;

    /**
     * 登录判断:通过用户名和密码得到用户
     *
     * @param userName 用户名
     * @param password 密码
     * @return 用户
     */
    @Cacheable(value = "userCache", key = "#userName")
    public User getUserEntityByNameAndPwd(String userName, String password) {
        UserExample userEntityExample = new UserExample();
        userEntityExample.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
        List<User> userEntityList = userDAO.selectByExample(userEntityExample);
        if (null != userEntityList && 0 < userEntityList.size()) {
            return userEntityList.get(0);
        }
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param userEntity 要更新的实体类，必须包括主键
     * @return
     */
    public int updateUserByUserId(User userEntity) {
        return userDAO.updateByPrimaryKeySelective(userEntity);
    }


    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    public User getUserEntityByUserName(String userName) {
        UserExample userEntityExample = new UserExample();
        userEntityExample.createCriteria().andUserNameEqualTo(userName);
        List<User> userEntityList = userDAO.selectByExample(userEntityExample);
        if (null != userEntityList && 0 < userEntityList.size()) {
            return userEntityList.get(0);
        }
        return null;
    }

    /**
     * 根据用户ID 查询用户
     *
     * @param userId
     * @return
     */
    public User getUserEntityByUserId(Long userId) {
        return userDAO.selectByPrimaryKey(userId);
    }

    /**
     * 根据用户邮箱查询用户
     *
     * @param email
     * @return
     */
    public User getUserEntityByEmail(String email) {
        UserExample userEntityExample = new UserExample();
        userEntityExample.createCriteria().andEmailEqualTo(email);
        List<User> userEntityList = userDAO.selectByExample(userEntityExample);
        if (null != userEntityList && 0 < userEntityList.size()) {
            return userEntityList.get(0);
        }
        return null;
    }

    /**
     * 保存用户、用户角色信息
     *
     * @param userEntity 要保存的实体类，必须包括主键
     * @return
     */
    public int insertUserByUserAndUserRole(User userEntity, UserRole userRole) {
        userRoleDAO.insertSelective(userRole);
        return userDAO.insertSelective(userEntity);
    }

    /**
     * 更新用户、用户角色信息
     *
     * @param userEntity 要更新的实体类，必须包括主键
     * @return
     */
    public int updateUserByUserAndUserRole(User userEntity, UserRole userRole) {
        userRoleDAO.updateByPrimaryKeySelective(userRole);
        return userDAO.updateByPrimaryKeySelective(userEntity);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public int deleteUser(Long userId) throws Exception {
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId);
        userRoleDAO.deleteByExample(userRoleExample);
        return userDAO.deleteByPrimaryKey(userId);
    }

    /**
     * 根据Map条件查询用户
     * @param requestMap
     * @param currentPage 当前页数
     * @param showCount 每页显示的条数
     * @return
     */
    public List<UserRoleDTO> getUserByMap(Map<String, String> requestMap, int currentPage, int showCount) {
        PageHelper.startPage(currentPage, showCount);
        return userDAO.getUserByMap(requestMap);
    }

    /**
     * 根据UserID得到UserRole
     *
     * @param userId
     * @return
     */
    public UserRoleDTO getUserRoleByUserId(long userId) {
        List<UserRoleDTO> userRoleDTOList = userDAO.getUserRoleByUserId(userId);
        if (null != userRoleDTOList && userRoleDTOList.size() > 0) {
            return userRoleDTOList.get(0);
        }
        return null;
    }
}
