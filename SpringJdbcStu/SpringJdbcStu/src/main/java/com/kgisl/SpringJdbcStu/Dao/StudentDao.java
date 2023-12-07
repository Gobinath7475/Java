package com.kgisl.SpringJdbcStu.Dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kgisl.SpringJdbcStu.Mapper.StudentRowMapper;
import com.kgisl.SpringJdbcStu.model.Student;

@Repository
@Transactional
public class StudentDao {
    {
        System.out.println("DAO loaded");
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate2) {
    }

    public Student getStudent(final int id) {
        Student student = jdbcTemplate.queryForObject("select * from student where sid = ?", new Object[] { id },
                new StudentRowMapper());
        return student;
    }

    public List<Student> getStudents() {
        List<Student> student = jdbcTemplate.query("select * from student", new StudentRowMapper());
        return student;
    }

    public void addStudent(final Student student) {
        jdbcTemplate.update("insert into student( sid , sname, sdept) values(?, ? , ?)",
                new Object[] { student.getSid(), student.getSname(), student.getSdept() });
    }

    public void updateStudent(final Student student) {
        jdbcTemplate.update("update student set sname = ?, sdept = ? where sid = ?",
                new Object[] { student.getSname(), student.getSdept(), student.getSid() });
    }

    public void deleteStudent(final int id) {
        jdbcTemplate.update("delete from student where sid = ?", new Object[] { id });
    }

    public Student getTeacher(int id) {
        return null;
    }
}
