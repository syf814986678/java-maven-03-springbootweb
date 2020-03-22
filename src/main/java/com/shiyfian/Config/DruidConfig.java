package com.shiyfian.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class    DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    //后台监控
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台登录账号密码配置
        HashMap<String,String> initparameters = new HashMap<>();
        //增加配置
        initparameters.put("loginUsername", "admin");//key是固定的
        initparameters.put("loginPassword", "123456");//key是固定的
        //允许谁可以访问
        initparameters.put("allow", "");//空为所有人都能访问，localhost本地可以访问
        //禁止谁可以访问initparameters.put("allow", "192.168.1.23");
        statViewServletServletRegistrationBean.setInitParameters(initparameters);//设置初始化参数
        return statViewServletServletRegistrationBean;
    }
}
