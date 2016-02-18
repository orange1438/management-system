# config说明

## 参考来源：
1. http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-config </br>
2. http://blog.csdn.net/xiao__gui/article/details/46803193 </br>
3. http://my.oschina.net/dlpinghailinfeng/blog/534653?fromerr=ItZnHgOa  </br>
4. http://blog.csdn.net/sunhuwh/article/details/25424855     </br>

* web.xml 对应 MyWebAppInitializer类
* ApplicationContext-mvc.xml 对应 MyApplicationContextMvcConfig类

# 说明
spring4中提供了大量的注解来支持零配置，简要说明如下：
@Configuration ： 类似于spring配置文件，负责注册bean，对应的提供了@Bean注解。需要org.springframework.web.context.support.AnnotationConfigWebApplicationContext注册到容器中。
@ComponentScan ： 注解类查找规则定义 <context:component-scan/>
@EnableAspectJAutoProxy ： 激活Aspect自动代理 <aop:aspectj-autoproxy/>
@Import @ImportResource: 关联其它spring配置  <import resource="" />
@EnableCaching ：启用缓存注解  <cache:annotation-driven/>
@EnableTransactionManagement ： 启用注解式事务管理 <tx:annotation-driven />
@EnableWebMvcSecurity ： 启用springSecurity安全验证


Servlet3.0规范，支持将web.xml相关配置也硬编码到代码中[servlet，filter，listener,等等]，并由javax.servlet.ServletContainerInitializer的实现类负责在容器启动时进行加载，
spring提供了一个实现类org.springframework.web.SpringServletContainerInitializer,
该类会调用所有org.springframework.web.WebApplicationInitializer的实现类的onStartup(ServletContext servletContext)方法，将相关的组件注册到服务器；

spring同时提供了一些WebApplicationInitializer的实现类供我们继承，以简化相关的配置，比如：
org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer ： 注册spring DispatcherServlet
org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer ： 注册springSecurity

同时，spring也提供了一些@Configuration的支持类供我们继承，以简化相关@Configuration的配置，比如：
org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport ： 封装了springmvc相关组件，我们可以通过注册新的@Bean和@Override相关方法，以实现对各个组件的注册；
org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter ： 封装类springsecurity相关组件
