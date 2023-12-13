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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.service.SupplierServiceInterface;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {

	@Autowired
	SupplierServiceInterface service;
	
	@GetMapping("/select/suppliers")
	public List<Suppliers> getAllData(){
		return service.getAllData();
	}
	
	@GetMapping("/select/suppliersbyId/{id}")
	public List<Suppliers> getById(@PathVariable("id") String id){
		return service.getById(id);
		
	}
	
	@PostMapping("/save/suppliers")
	public String insert(@RequestBody Suppliers s) {
		try {
			List<Suppliers> data = service.getById(s.get_id());
			
			if (data==null){
				service.saveData(s);
				return "Inserted Successfully";
			}
			else{
				return "Raw Material already exists";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Intenal error";
		}


	}
	
	@PutMapping("/update/supplier")
	public String update(@RequestBody Suppliers s) {
		try {
			List<Suppliers> data = service.getById(s.get_id());
			
			if (data==null){
				service.update(s);
				return "Updated Successfully";
			}
			else{
				return "Raw Material does not exists";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Intenal error";
		}


	}
	
	@DeleteMapping("/delete/supplier/{id}")
	public String delete(@PathVariable("id") String id) {
		try {
			List<Suppliers> data = service.getById(id);
			
			if (data==null){
				service.delete(id);
				return "Deleted Successfully";
			}
			else{
				return "Raw Material does not exists";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Intenal error";
		}
	}
	
	@PutMapping("/update/supplier-name")
	public String updateName(@RequestParam String oldName , @RequestParam String newName) {
		service.updateSupplierName(oldName, newName);
		return "Updated Name Successfully";
	}
}
