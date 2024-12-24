package in.nagendra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import in.nagendra.entity.Student;
import in.nagendra.service.StudentService;
import jakarta.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentService stuService;

    @GetMapping("/")
    public String studentForm(Model model) {
        Student stuObj = new Student();
        model.addAttribute("student", stuObj);
        return "index";
    }

    @PostMapping("/student")
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult result,
                              @RequestParam("resume") MultipartFile resumeUrl, Model model) {
        
        if (result.hasErrors()) {
            return "index"; // If validation errors, return to form
        }
        
        if (resumeUrl.isEmpty()) {
            model.addAttribute("emsg", "Resume is required.");
            return "index"; // If file is not selected, return with error
        }
        
        boolean saved = stuService.saveStudent(student, resumeUrl);
        
        if (saved) {
            model.addAttribute("smsg", "Student added successfully.");
        } else {
            model.addAttribute("emsg", "Error adding student.");
        }
        return "index"; // After saving, return to the form view
    }

    @GetMapping("/students")
    public String viewStudents(Model model) {
        List<Student> students = stuService.getAllStudents();
        model.addAttribute("students", students); // Correct model attribute name
        return "student"; // Page to display the list of students
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("sid") Integer sid, Model model) {
        Student studentById = stuService.getUserById(sid);
        model.addAttribute("student", studentById);
        return "index"; // Returning to the form for editing
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("sid") Integer sid, Model model) {
        boolean isDeleted = stuService.deleteUser(sid);

        if (isDeleted) {
            model.addAttribute("smsg", "Student Deleted");
            List<Student> allStudents = stuService.getAllStudents();
            model.addAttribute("students", allStudents); // Updated model name
        } else {
            model.addAttribute("emsg", "Student not deleted");
        }
        return "redirect:/students"; // After delete, redirect to students list page
    }
}
