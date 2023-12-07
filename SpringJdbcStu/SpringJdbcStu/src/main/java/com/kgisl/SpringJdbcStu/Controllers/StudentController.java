package com.kgisl.SpringJdbcStu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kgisl.SpringJdbcStu.model.Student;
import com.kgisl.SpringJdbcStu.Service.StudentService;

@Controller
@RequestMapping(value = "/students")

public class StudentController {

    @Autowired
    private StudentService StudentService;

    @RequestMapping("/")
	public String getStudents(ModelMap studentmodel) {
		System.out.println("studentcontrol loaded ...............");

		List<Student> students = StudentService.getStudents();
		//students.stream().forEach(System.out::println);
		studentmodel.addAttribute("students", students);
		return "students";
	}

    // Method to show the form for adding a new teacher
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudentForm"; // Assuming you have a JSP named "addStudentForm.jsp"
    }

    // Method to handle the form submission
    @PostMapping("/add")
    public String processAddStudentForm(@ModelAttribute Student student, Model model) {
        // Process the submitted form data (save to database, etc.)
        StudentService.addStudent(student);

        // Redirect to the list of teachers after adding a new one
        return "redirect:/students/";
    }

    // Method to show the form for editing an existing teacher
    @GetMapping("/update/{id}")
    public String showEditStudentForm(@PathVariable("id") int id, Model model) {
        Student existingStudent = StudentService.getsStudent(id);
        model.addAttribute("student", existingStudent);
        return "editStudentForm";
    }

    // Method to handle the form submission for updating an existing student
    @PostMapping("/update/{id}")
    public String processEditStudentForm(@PathVariable("id") int id, @ModelAttribute("student") Student updatedStudent,
            Model model) {
        updatedStudent.setSid(id);  // Assuming setSid() is the method in your Student class to set the student ID
        StudentService.updateStudent(updatedStudent);
        return "redirect:/students/";
    }

    // Method to handle the DELETE request for deleting a teacher
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        StudentService.deleteStudent(id);
        // Redirect to the list of teachers after deleting one
        return "redirect:/students/";
    }
}
