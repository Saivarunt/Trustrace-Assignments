package com.example.springmongo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(Student s){
        return studentRepository.save(s);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    
    public Student postStudent(String fn,String ln, String email, Gender g, Address address, List<String> sub, BigDecimal total, LocalDateTime ldt){
        Student ns = new Student(fn,ln,email,g,address,sub,total,ldt);
        return studentRepository.save(ns);
    }

    public void delStudent(String id){
        studentRepository.deleteById(id);
    }
    public Optional<Student> findByID(String id){
        return studentRepository.findById(id);
    }
}
