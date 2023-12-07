package com.kgisl.SpringJdbcStu.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kgisl.SpringJdbcStu.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setSid(rs.getInt("sid"));
        student.setSname(rs.getString("sname"));
        student.setSdept(rs.getString("sdept"));
        return student;
    }
}
