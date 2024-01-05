package com.example.supply_chain.model;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "login")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login{
    @Id
    private String _id;

    private String username;

    private String email;

    private String password;

    private String role;

}
