package com.kgisl.SpringJdbcStu.Config;

import javax.sql.DataSource;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kgisl.SpringJdbcStu.model.helloworld;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kgisl.SpringJdbcStu")
public class WebConfig implements WebMvcConfigurer {

    {
        System.out.println("-----------------Webconfig loaded------------------");
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Gobinath T");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
 
    @Bean
    @Scope("singleton")
    public helloworld helloworld() {
        return new helloworld();
    }

    @Bean
    @Scope("singleton")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}

