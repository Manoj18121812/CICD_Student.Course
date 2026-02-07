package com.example.StudentCrud.Service;

import com.example.StudentCrud.Entity.Student;
import com.example.StudentCrud.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo){
        this.repo=repo;
    }

    public List<Student> getAll(){
        return repo.findAll();
    }

    public Student save(Student s){
        return repo.save(s);
    }

    public Student findById(Long id){
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id){
    repo.deleteById(id);
    }
}
