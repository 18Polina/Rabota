package com.example.Rabota.Controller;


import com.example.Rabota.Models.Students;
import com.example.Rabota.repo.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RabotaController {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/")
public String GetRab(Model model)
    {
        Iterable<Students> students = studentsRepository.findAll();
        model.addAttribute("students",students);
        return "Main";
    }
    @GetMapping("/Add/Student")
    public String GetAddStudent(Model model)
    {
        return "Add-Student";
    }
    @PostMapping("/Add/Student")
    public String blogPostAdd(@RequestParam(value="lastname") String lastname,
                              @RequestParam(value ="name" ) String name,
                              @RequestParam(value = "maiddlename") String maiddlename,
                              @RequestParam(value ="birthday" ) String birthday,
                              @RequestParam(value = "groupp") int groupp,
                              Model model)
    {
        Students student = new Students(lastname,name,maiddlename,  birthday,groupp);
        studentsRepository.save(student);
        return "redirect:/";
    }


    @GetMapping( path = "/Search/Student")
    public String blogFilter(Model model)
    {
        return "Search-Student";
    }

    @PostMapping("/Search/Student-result")
    public String blogResult(@RequestParam String lastname, Model model)
    {
        List<Students> stud = studentsRepository.findByLastname(lastname);
        model.addAttribute("result", stud);
        return "Search-Student";
    }
    @PostMapping("/Search/Student")
    public String simpleSearch(@RequestParam String lastname, Model model)
    {
        List<Students> stud = studentsRepository.findByLastnameContains(lastname);
        model.addAttribute("result", stud);
        return "Search-Student";
    }


}
