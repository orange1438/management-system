package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.UserEntityDAO;
import indi.orange1438.managementsystem.dao.entity.UserEntity;
import indi.orange1438.managementsystem.dao.entity.UserEntityExample;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserEntityDAO userDAO;

    /**
     * 登录判断:通过用户名和密码得到用户
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public UserEntity getUserEntityByNameAndPwd(String userName, String password) {
        UserEntityExample userEntityExample = new UserEntityExample();
        userEntityExample.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
        List<UserEntity> userEntityList = userDAO.selectByExample(userEntityExample);
        if (null != userEntityList && 0 < userEntityList.size()) {
            return userEntityList.get(0);
        }
        return null;
    }
}
