package com.kgisl.SpringJdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class RegistrationDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    } 

    public List<Registration> listall() {
        String query = "SELECT * FROM registration";
        return jdbcTemplate.query(query,new RegistrationMapper());
    }
}
