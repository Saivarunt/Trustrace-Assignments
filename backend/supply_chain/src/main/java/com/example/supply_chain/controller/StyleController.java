package com.example.supply_chain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supply_chain.model.style;
import com.example.supply_chain.service.StyleServiceInterface;


@RestController
@RequestMapping("/style")
public class StyleController {

	@Autowired
	StyleServiceInterface service;
	
	// @GetMapping("/test")
	// public String display() {		
	// 	return "hihello";		
	// }
	
	@GetMapping("/select-style")
	public ResponseEntity<List<style>> select() {		
		try {
			return new ResponseEntity<List<style>>(service.getAllStyle(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping("/select/stylebyId/{id}")
	public ResponseEntity<List<style>> selectById(@PathVariable("id") String id){
		try {
			return new ResponseEntity<List<style>>(service.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/add/style")
	public ResponseEntity<style> insert(@RequestBody style s) {
		try {
			List<style> data = service.getByUid(s.getStyleUid());
			
			if (data.isEmpty()){
				return new ResponseEntity<>(service.addData(s), HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(new style(), HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/style")
	public ResponseEntity<style> update(@RequestBody style s) {

		try {
			List<style> data = service.getByUid(s.getStyleUid());	
			if (data.isEmpty()==false){
				return new ResponseEntity<>(service.updateData(s), HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(new style(), HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	
	@DeleteMapping("/delete/style/{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") String id) {
		try {
			List<style> data = service.getById(id);	
			if (data.isEmpty()==false){
				;
				return new ResponseEntity<>(service.deleteData(id),HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(false,HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>( false, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/select/style/dao")
	public List<style> getData(){
		return service.getAllData();
	}																													
}
