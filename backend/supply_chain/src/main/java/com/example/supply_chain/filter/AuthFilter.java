package com.example.supply_chain.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFilter extends OncePerRequestFilter{
    public Boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey("*U(8hj908ns98daniasudfniawur97q2e7r2934892rnu213rn09217349782190348y12").parseClaimsJws(token);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                String authHeader = request.getHeader("Authorization");
                
                // .split(" ",2)[1];
                // if(authHeader==null || !authHeader.startsWith("Bearer "))
                // {
                //     filterChain.doFilter(request, response);
                //     return;
                // }
                String token=authHeader.substring(7);
                Boolean validationResponse = validateToken(token);
                if(!validationResponse){
                    throw new RestClientException("Unauthorized Exception");
                }
                filterChain.doFilter(request, response);
    }
}
