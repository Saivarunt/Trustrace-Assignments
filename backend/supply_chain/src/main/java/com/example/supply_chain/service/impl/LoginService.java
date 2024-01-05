package com.example.supply_chain.service.impl;


import io.jsonwebtoken.*;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.supply_chain.config.SecurityConfig;
import com.example.supply_chain.model.Login;
import com.example.supply_chain.repository.LoginRepository;

@Service
public class LoginService{
    @Autowired
    LoginRepository repo;

    @Autowired
    SecurityConfig securityConfig;

    public Login save(Login l){
        l.setPassword(securityConfig.passwordEncoder().encode(l.getPassword()));
        return repo.save(l);
    }



    public String generateToken(String username,String pwd){
        // throw new NullPointerException();// Exception test

        Claims claims = Jwts.claims().setSubject(username);
        System.out.println("claims :"+claims);
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,"*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").compact();

        System.out.println("token :"+token);
        return token;
    }
    
    public String generateTokenWithRole(String username,String pwd){
        // throw new NullPointerException();// Exception test
        Map <String,String> map = new HashMap<>();
        map.put("Role", "admin");
        Claims claims = Jwts.claims().setSubject(username);
        claims.putAll(map);

        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,"*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").compact();
        System.out.println("token :"+token);
        return token;
    }
    
    public Boolean validateToken(String token,String name){
        // throw new RuntimeException(); // Exception test
        Jws<Claims> j=Jwts.parser().setSigningKey("*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").parseClaimsJws(token);
        // if(token.equals(generateToken(name, ""))){
        //     return "Valid";
        // }
        // return "Invalid";
        // return j.getBody().getSubject();
        if(j.getBody().getSubject().equals(name)){
            return true;
        }
        return false;
    }

    public Boolean validateWithRoleToken(String token,String role){
        // throw new RuntimeException(); // Exception test
        Jws<Claims> j=Jwts.parser().setSigningKey("*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").parseClaimsJws(token);
        System.out.println(j.getBody().get("Role"));
        // if(token.equals(generateToken(name, ""))){
        //     return "Valid";
        // }
        // return "Invalid";
        // return j.getBody().getSubject();
        if(j.getBody().get("Role").equals(role)){
            return true;
        }
        return false;
    }


}