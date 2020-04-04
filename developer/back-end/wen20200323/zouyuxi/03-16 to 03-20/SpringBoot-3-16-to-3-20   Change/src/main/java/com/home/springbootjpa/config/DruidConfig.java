package com.home.springbootjpa.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 邹玉玺
 * @date: 2020/3/18-16:56
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource getSource() {
        return new DruidDataSource();
    }

    //配置Druid的监控
    //首先配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置初始化参数
        Map<String, String> initparameters = new HashMap<>();
        initparameters.put("loginUsername", "admin");
        initparameters.put("loginPassword", "admin");
        initparameters.put("allow", "");//value不写默认全部允许
        bean.setInitParameters(initparameters);
        return bean;
    }

    //配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //设置初始化参数
        Map<String, String> initparameters = new HashMap<>();
        initparameters.put("exclusions", "*.js,*.css,/druid");
        bean.setInitParameters(initparameters);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
