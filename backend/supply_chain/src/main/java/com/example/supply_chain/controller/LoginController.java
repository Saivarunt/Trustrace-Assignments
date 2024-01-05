package com.example.supply_chain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.supply_chain.model.Login;
import com.example.supply_chain.service.impl.LoginService;
import com.example.supply_chain.service.impl.UserService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService service;

    @PostMapping("/{username}/{pwd}")
    public String login(@PathVariable String username, @PathVariable String pwd ){
        return service.generateToken(username,pwd);
    }
    @Autowired
    UserService service2;

    @PostMapping("rolebased/{username}/{pwd}")
    public String roleBasedLogin(@PathVariable String username, @PathVariable String pwd ){
        return service.generateTokenWithRole(username,pwd);
    }

    @PostMapping("/")
    public ResponseEntity<Login> logindetails(@RequestBody Login l){
        // String token = service.generateToken(l.getUsername(),l.getPassword());
        return new ResponseEntity<>(service.save(l),HttpStatus.OK);
    }

    @GetMapping("/ga")
    public ResponseEntity<?> grantedauth() {
        return new ResponseEntity<>(service2.findUser(),HttpStatus.OK);
        // return service2;
    }
    

    @GetMapping("/verify/{name}")
    public Boolean tokenValidation(HttpServletRequest request, @PathVariable String name) {
        return service.validateToken(request.getHeader("Authorization").split(" ",2)[1],name);
    }
    
    // @PreAuthorize(value = "") // for role based access
    @GetMapping("/verifyrole/{role}")
    public Boolean validateRole(HttpServletRequest request, @PathVariable String role) {
        return service.validateWithRoleToken(request.getHeader("Authorization").split(" ",2)[1],role);
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
