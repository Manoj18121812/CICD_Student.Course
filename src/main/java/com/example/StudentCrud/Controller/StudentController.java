package com.example.StudentCrud.Controller;


import com.example.StudentCrud.Entity.Student;
import com.example.StudentCrud.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service=service;
    }

    @GetMapping("/")
    public String viewHome(Model model){
      model.addAttribute("students",service.getAll());
      return "index";
    }

    @GetMapping("/add")
    public String addFrom(Model model){
        model.addAttribute("student",new Student());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student){
    service.save(student);
    return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
    model.addAttribute("student",service.findById(id));
    return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Student student){
        service.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/";
    }
}
