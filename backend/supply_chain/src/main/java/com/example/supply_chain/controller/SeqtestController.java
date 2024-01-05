package com.example.supply_chain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.supply_chain.service.impl.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SeqtestController {
    @Autowired
    LoginService loginService;

    @GetMapping("/hello/{name}")
    public ResponseEntity<?> hello(HttpServletRequest req, @PathVariable String name) {
        if (loginService.validateToken(req.getHeader("Authorization").split(" ",2)[1],name)){
            return new ResponseEntity<>("Hello",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Unauthorized",HttpStatus.UNAUTHORIZED);
        }
        
    }

    @GetMapping("/greeting/{name}")
    public ResponseEntity<?> greet(HttpServletRequest req, @PathVariable String name){
        if (loginService.validateToken(req.getHeader("Authorization").split(" ",2)[1],name)){
            return new ResponseEntity<>("Hey "+name,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Unauthorized",HttpStatus.UNAUTHORIZED);
        }
    }
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> runtimeExeHandle(){
        return new ResponseEntity<>("UNAUTHORIZED EXE", HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<?> nullPointerExeHandle(){
        return new ResponseEntity<>("Null Pointer EXE", HttpStatus.CONFLICT);
    }
}
