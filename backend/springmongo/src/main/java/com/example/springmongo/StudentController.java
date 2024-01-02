package com.example.springmongo;

import java.math.BigDecimal;
import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("api/v1/students")
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping(path = "api/stud",consumes = {"application/json"})
    public ResponseEntity<Student> addStudent(@RequestBody Student nstud){
        nstud.setCreated(LocalDateTime.now());
        Student svd = studentService.save(nstud);
        // studentService.postStudent(stud.getFirstName(),stud.getLastName(),stud.getEmail(),stud.getGender(),stud.getAddress(),stud.getFavSub(),stud.getTotalSpentInBooks());
        if (svd==null){
            try {
                throw new SerialException();
            } catch (SerialException e) {
                e.printStackTrace();
            }
        }
        else{
            return new ResponseEntity<>(svd,HttpStatus.CREATED);
        } 
        return new ResponseEntity<>(svd,HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping(path = "api/put/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable String id, @RequestBody Student updst){
        
        Student svd =null;
        try {
            svd = studentService.findByID(id).orElseThrow(() -> new Exception("Student does not exist with id: " + id));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(svd,HttpStatus.BAD_REQUEST);
        }
        svd.setFirstName(updst.getFirstName());
        svd.setLastName(updst.getLastName());
        studentService.save(svd);
        return new ResponseEntity<>(svd,HttpStatus.CREATED);
    }

    @DeleteMapping(path = "api/del/{id}")
    public String delStudent(@PathVariable String id){
        studentService.delStudent(id);
        return "Successfully Deleted "+id;
    }

}
