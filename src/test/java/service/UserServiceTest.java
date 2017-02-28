package service;

import com.sun.tools.javac.util.Assert;
import indi.orange1438.managementsystem.service.system.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * UserService单元测试
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/28 0:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
/** 注入相关的配置文件：可以写入多个配置文件 **/
@ContextConfiguration(locations = {"classpath:spring/spring-profile.xml", "classpath:spring/spring-service.xml", "classpath:spring/spring-dao.xml"})
@Transactional
@Rollback(true)
@ActiveProfiles({"dev"})
public class UserServiceTest {

    @Resource(name = "userService")
    UserService userService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getUserEntityByNameAndPwd() throws Exception {
        Assert.checkNonNull(userService.getUserEntityByNameAndPwd("admin", "111111"));
    }

}