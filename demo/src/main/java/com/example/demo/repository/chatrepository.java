package com.example.demo.repository;
import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.chat;

public interface chatrepository extends CrudRepository<chat, String> {
	List<chat> findByVanishMode(boolean val);
	List<chat> findByVanishModeAndChatId(boolean val,String cid);
	
    @Query(value = "SELECT c FROM chat c ORDER BY chatId")
    public List<chat> findAllSortedByChatId();
    
    @Query(value = "SELECT c FROM chat c")
    public List<chat> findAllChat();
}