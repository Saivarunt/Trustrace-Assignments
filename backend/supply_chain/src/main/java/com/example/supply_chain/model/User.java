package com.example.supply_chain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @AllArgsConstructor
// @NoArgsConstructor
@Data
// @Document(value = "user")
public class User extends Login implements UserDetails{

    private List<GrantedAuthority> grantedAuthorities;

    public User(Login l){
        super(l.get_id(),l.getUsername(),l.getEmail(),l.getPassword(),l.getRole());
        System.out.println(l.getRole());
        System.out.println("in");
        grantedAuthorities = List.of(new SimpleGrantedAuthority(super.getRole()));
        System.out.println(grantedAuthorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("ga: "+grantedAuthorities);
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
