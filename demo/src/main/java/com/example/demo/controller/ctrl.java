package com.example.demo.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.example.demo.repository.chatrepository;
import com.example.demo.service.chatService;
import com.example.demo.model.chat;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/response")
public class ctrl{
	
//	@Autowired
//	chatrepository crep;
	
	@Autowired
	chatService crep;
	
	@GetMapping("/")
	String egcontroller() {
		return "Hello";
	}
	
	@GetMapping(value={"/val"})
	List<String> eg2controller(@RequestParam(required=false,name="users") List<String> name) {
		return name;
	}
	
	@GetMapping(value={"/hello","/hello/{id}/{val}","/hello/"})
	String eg1controller(@PathVariable(required=false) String id,@RequestBody String val1) {

		return "Hello "+id+" "+val1;
	}
	
	@PostMapping("/postbody")
    public String postBody(@RequestBody String fullName) {
        return "Hello " + fullName;
    }
	
	@GetMapping("/db")
	List<chat> valeg() {
//		chat cob = new chat("102","direct",false,"default");
//		chat cob = new chat("103","direct",true,"default");
//		return crep.save(cob);
		return crep.findByVanishModeAndChatId(true,"101");
	}
}
