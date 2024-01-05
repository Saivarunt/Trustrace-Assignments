package com.example.supply_chain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.supply_chain.model.Login;
import com.example.supply_chain.model.User;
import com.example.supply_chain.repository.LoginRepository;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    LoginRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User details = new User(repo.findByUsername(username));
        System.out.println(details);
        return details;
    }

    public List<User> findUser (){
        return repo.findAll().stream().map(User::new).toList();
    }
}
