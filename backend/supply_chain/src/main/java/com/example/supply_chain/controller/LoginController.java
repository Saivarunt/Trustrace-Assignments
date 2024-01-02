package com.example.supply_chain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.supply_chain.service.impl.LoginService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService service;

    @PostMapping("/{username}/{pwd}")
    String login(@PathVariable String username, @PathVariable String pwd ){
        return service.generateToken(username,pwd);
    }

    @GetMapping("/verify/{name}")
    public String getMethodName(HttpServletRequest request, @PathVariable String name) {
        return service.validateToken(request.getHeader("Authorization").split(" ",2)[1],name);
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
