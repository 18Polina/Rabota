package com.example.Rabota.Controller;

import com.example.Rabota.Models.Students;
import com.example.Rabota.Models.Teacher;
import com.example.Rabota.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping("/Teach")
    public String GetRab(Model model)
    {
        Iterable<Teacher> teacher = teacherRepository.findAll();
        model.addAttribute("teacher",teacher);
        return "MainTeach";
    }
    @GetMapping("/Add/Teacher")
    public String GetAddStudent(Model model)
    {
        return "Add-Teacher";
    }
    @PostMapping("/Add/Teacher")
    public String blogPostAdd(@RequestParam(value="surname") String surname,
                              @RequestParam(value ="name" ) String name,
                              @RequestParam(value = "middlename") String middlename,
                              @RequestParam(value ="bthday" ) String bthday,
                              @RequestParam(value = "yearprepodav") int yearprepodav,
                              Model model)
    {
        Teacher teacher = new Teacher(surname,name,middlename,  bthday,yearprepodav);
        teacherRepository.save(teacher);
        return "redirect:/Teach";
    }
    @GetMapping( path = "/Search/Teacher")
    public String blogFilter(Model model)
    {
        return "Search-Teacher";
    }

    @PostMapping("/Search/Teacher-result")
    public String blogResult(@RequestParam String surname, Model model)
    {
        List<Teacher> teach = teacherRepository.findBySurname(surname);
        model.addAttribute("result", teach);
        return "Search-Teacher";
    }
    @PostMapping("/Search/Teacher")
    public String simpleSearch(@RequestParam String surname, Model model)
    {
        List<Teacher> teach = teacherRepository.findBySurnameContains(surname);
        model.addAttribute("result", teach);
        return "Search-Teacher";
    }
}
