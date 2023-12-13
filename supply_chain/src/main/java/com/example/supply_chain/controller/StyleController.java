package com.example.supply_chain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/test")
	public String display() {		
		return "hihello";		
	}
	
	@GetMapping("/select-style")
	public List<style> select() {		
		return service.getAllStyle();		
	}
	
	@GetMapping("/select/stylebyId/{id}")
	public List<style> selectById(@PathVariable("id") String id){
		return service.getById(id);
		
	}
	
	@PostMapping("/add/style")
	public String insert(@RequestBody style s) {
		try {
			List<style> data = service.getById(s.get_id());
			
			if (data==null){
			service.addData(s);
			return "Inserted Successfully";
			}
			else{
				return "Style already exists";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Intenal error";
		}
	}
	
	@PutMapping("/update/style")
	public String update(@RequestBody style s) {

		try {
			List<style> data = service.getById(s.get_id());	
			if (data==null){
				service.updateData(s);
				return "Updated Successfully";
			}
			else{
				return "Style does not exists";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Intenal error";
		}
	}

	
	@DeleteMapping("/delete/style/{id}")
	public String deleteById(@PathVariable("id") String id) {
		try {
			List<style> data = service.getById(id);	
			if (data==null){
				service.deleteData(id);
				return "deleted Successfully";
			}
			else{
				return "Style does not exists";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Intenal error";
		}

	}
	
	@GetMapping("/select/style/dao")
	public List<style> getData(){
		return service.getAllData();
	}																													
}
