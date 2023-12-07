package com.kgisl.SpringJdbcStu.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.SpringJdbcStu.Dao.StudentDao;
import com.kgisl.SpringJdbcStu.model.Student;
@Service
public class StudentService {
	{
		System.out.println("StudentService");
	}
	@Autowired
	private StudentDao studentDao;
	public Student getsStudent(final int id) {
		return studentDao.getStudent(id);
	}
	public List<Student> getStudents() {
		return studentDao.getStudents();
	}
	public void addStudent(final Student student) {
		studentDao.addStudent(student);
	}
	public void updateStudent(final Student student) {
		studentDao.updateStudent(student);
	}
	public void deleteStudent(final int id) {
		studentDao.deleteStudent(id);
	}
}
