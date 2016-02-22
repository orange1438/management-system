package com.ManagementSystem.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/18 0018.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ManagementSystem.controller")
public class MyApplicationContextMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 描述 : <注册消息资源处理器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
//    @Bean
//    public MessageSource messageSource() {
//        System.out.println("===================注册消息资源处理器==============");
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("config.messages.messages");
//
//        return messageSource;
//    }

    /**
     * 描述 : <注册servlet适配器>. <br>
     *<p>
     <只需要在自定义的servlet上用@Controller("映射路径")标注即可>
     </p>
     * @return
     */
//    @Bean
//    public HandlerAdapter servletHandlerAdapter(){
//        System.out.println("注册servlet适配器");
//        return new SimpleServletHandlerAdapter();
//    }


    /**
     * 描述 : <本地化拦截器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
//    public LocaleChangeInterceptor localeChangeInterceptor(){
//        System.out.println("本地化拦截器");
//        return new LocaleChangeInterceptor();
//    }


    /**
     * 描述 : <基于cookie的本地化资源处理器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
//    @Bean(name="localeResolver")
//    public CookieLocaleResolver cookieLocaleResolver(){
//        System.out.println("基于cookie的本地化资源处理器");
//        return new CookieLocaleResolver();
//    }


    /**
     * 描述 : <添加拦截器>. <br>
     <使用方法说明>
     添加Spring MVC的预处理和后期处理生命周期拦截器控制器方法调用。
     * @param registry
     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        // TODO Auto-generated method stub
//        System.out.println("添加拦截器 start");
//        registry.addInterceptor(localeChangeInterceptor());
//        System.out.println("添加拦截器 end");
//    }

    /**
     * 描述 : <资源访问处理器>. <br>
     <可以在jsp中使用/static/**的方式访问/WEB-INF/static/下的内容>
     添加处理程序为静态资源,如图片、js、,css文件从特定位置在web应用程序的根下,类路径等等。
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("资源访问处理器");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    /**
     * 描述 : <注册试图处理器>.
     * @return
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {

        System.out.println("=================== init 注册试图处理器 =======================");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    /**
     * 描述 : <文件上传处理器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
//    @Bean(name="multipartResolver")
//    public CommonsMultipartResolver commonsMultipartResolver(){
//        System.out.println("文件上传处理器");
//        return new CommonsMultipartResolver();
//    }

    /**
     * 描述 : <异常处理器>. <br>
     *<p>
     <系统运行时遇到指定的异常将会跳转到指定的页面>
     </p>
     * @return
     */
//    @Bean(name="exceptionResolver")
//    public CP_SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
//        logger.info("CP_SimpleMappingExceptionResolver");
//        CP_SimpleMappingExceptionResolver simpleMappingExceptionResolver= new CP_SimpleMappingExceptionResolver();
//        simpleMappingExceptionResolver.setDefaultErrorView("common_error");
//        simpleMappingExceptionResolver.setExceptionAttribute("exception");
//        Properties properties = new Properties();
//        properties.setProperty("java.lang.RuntimeException", "common_error");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        return simpleMappingExceptionResolver;
//    }

    /**
     * 描述 : <注册通用属性编辑器>. <br>
     *<p>
     <这里只增加了字符串转日期和字符串两边去空格的处理>
     </p>
     * @return
     */
//    @Override
//    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
//        System.out.println("ConfigurableWebBindingInitializer");
//        ConfigurableWebBindingInitializer initializer = super.getConfigurableWebBindingInitializer();
//        CP_PropertyEditorRegistrar register = new CP_PropertyEditorRegistrar();
//        register.setFormat("yyyy-MM-dd");
//        initializer.setPropertyEditorRegistrar(register);
//        return initializer;
//    }


}
