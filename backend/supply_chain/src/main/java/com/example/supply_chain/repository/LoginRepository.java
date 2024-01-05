package com.example.supply_chain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.supply_chain.model.Login;
import java.util.List;


@Repository
public interface LoginRepository extends MongoRepository<Login, String> {
    Login findByUsername(String username);
}
