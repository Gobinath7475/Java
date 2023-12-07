package com.kgisl.SpringJdbcStu.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kgisl.SpringJdbcStu.model.Teacher;
import com.kgisl.SpringJdbcStu.Service.TeacherService;


@Controller
@RequestMapping(value= "/teachers")

public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/")
	public String getTeachers(ModelMap teacherModel) {
		System.out.println("TeacherController loaded ...............");

		List<Teacher> teachers = teacherService.getTeachers();
		// teachers.stream().forEach(System.out::println);
		teacherModel.addAttribute("teachers", teachers);
		return "teachers";
	}

	// Method to show the form for adding a new teacher
    @GetMapping("/add")
    public String showAddTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "addTeacherForm"; // Assuming you have a JSP named "addTeacherForm.jsp"
    }

    // Method to handle the form submission
    @PostMapping("/add")
    public String processAddTeacherForm(@ModelAttribute Teacher teacher, Model model) {
        // Process the submitted form data (save to database, etc.)
        teacherService.addTeacher(teacher);

        // Redirect to the list of teachers after adding a new one
        return "redirect:/teachers/";
    }

	// Method to show the form for editing an existing teacher
    @GetMapping("/Update/{id}")
    public String showEditTeacherForm(@PathVariable("id") int id, Model model) {
        Teacher existingTeacher = teacherService.getTeacher(id);
        model.addAttribute("teacher", existingTeacher);
        return "editTeacherForm";
    }

    // Method to handle the form submission for updating an existing teacher
    @PostMapping("/update/{id}")
    public String processEditTeacherForm(@PathVariable("id") int id, @ModelAttribute Teacher updatedTeacher, Model model) {
        updatedTeacher.setId(id);
        teacherService.updateTeacher(updatedTeacher);
        return "redirect:/teachers/";
    }

	// Method to handle the DELETE request for deleting a teacher
    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") int id) {
        teacherService.deleteTeacher(id);
        // Redirect to the list of teachers after deleting one
        return "redirect:/teachers/";
    }
}