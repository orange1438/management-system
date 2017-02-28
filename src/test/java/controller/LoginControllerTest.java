package controller;

import com.alibaba.fastjson.JSON;
import indi.orange1438.managementsystem.web.system.login.LoginController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Controller Test
 * 参考http://www.cnblogs.com/0201zcr/p/5756642.html
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/28 12:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
/** 注入相关的配置文件：可以写入多个配置文件 **/
@ContextConfiguration(locations = {"classpath:spring/spring-profile.xml",
        "classpath:spring/spring-web.xml",
        "classpath:spring/spring-service.xml",
        "classpath:spring/spring-dao.xml"})
@Transactional
@Rollback(true)
@ActiveProfiles({"dev"})
@WebAppConfiguration
public class LoginControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;


    @Autowired
    LoginController loginController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void loginApi() throws Exception {
        try {
            String responseString = mockMvc.perform(
                    post("/login_login")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"loginName\":\"admin\",\"password\":\"111111\"}"))
                    .andExpect(status().isOk()).
                            andReturn()
                    .getResponse().getContentAsString();
            System.out.println("--------返回的json = " + responseString);
            assertEquals("nullcode", JSON.parseObject(responseString, Map.class).get("result"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}