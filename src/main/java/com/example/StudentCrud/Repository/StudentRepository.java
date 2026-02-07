package com.example.StudentCrud.Repository;

import com.example.StudentCrud.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
