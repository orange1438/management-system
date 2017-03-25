package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.UserDAO;
import indi.orange1438.managementsystem.dao.entity.User;
import indi.orange1438.managementsystem.dao.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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
     *
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> userList = userDAO.selectByExample(userExample);
        if (null != userList && 0 < userList.size()) {
            return userList.get(0);
        }
        return null;
    }
}
