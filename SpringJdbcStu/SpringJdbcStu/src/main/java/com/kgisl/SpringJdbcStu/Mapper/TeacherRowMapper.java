package com.kgisl.SpringJdbcStu.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kgisl.SpringJdbcStu.model.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher> {

    @Override
    public Teacher mapRow(ResultSet rs, int arg1) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setId(rs.getInt("id"));
        teacher.setName(rs.getString("name"));
        teacher.setExpertise(rs.getString("expertise"));
        return teacher;
    }
}
