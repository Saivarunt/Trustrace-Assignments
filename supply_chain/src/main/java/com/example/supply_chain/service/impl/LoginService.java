package com.example.supply_chain.service.impl;


import io.jsonwebtoken.*;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class LoginService {
    public String generateToken(String username,String pwd){
        // throw new NullPointerException();// Exception test

        Claims claims = Jwts.claims().setSubject(username);
        System.out.println("claims :"+claims);
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,"*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").compact();

        System.out.println("token :"+token);
        return token;
    }
    public String validateToken(String token,String name){
        // throw new RuntimeException(); // Exception test
        Jws<Claims> j=Jwts.parser().setSigningKey("*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").parseClaimsJws(token);
        // if(token.equals(generateToken(name, ""))){
        //     return "Valid";
        // }
        // return "Invalid";
        return j.getBody().getSubject();
    }
}