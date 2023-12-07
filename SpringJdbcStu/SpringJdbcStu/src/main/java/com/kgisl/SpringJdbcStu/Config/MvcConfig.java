package com.kgisl.SpringJdbcStu.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kgisl.SpringJdbcStu.Dao.StudentDao;
 
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
    {
    System.out.println("-----------------Mvc config loaded------------------");
    }

    @Autowired
   private JdbcTemplate jdbcTemplate;
   
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
   }
   
   @Bean
   public StudentDao studentDao() {
      return new StudentDao(jdbcTemplate);
   }

}
