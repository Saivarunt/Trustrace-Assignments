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
	public ResponseEntity<List<Suppliers>> getAllData(){
		try {
			return new ResponseEntity<>(service.getAllData(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/suppliersbyId/{id}")
	public ResponseEntity<List<Suppliers>> getById(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/save/suppliers")
	public ResponseEntity<String> insert(@RequestBody Suppliers s) {
		try {
			List<Suppliers> data = service.getById(s.get_id());
			
			if (data==null){
				service.saveData(s);
				return new ResponseEntity<String>("Inserted Successfully", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Raw Material already exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Intenal error",HttpStatus.BAD_REQUEST);
		}


	}
	
	@PutMapping("/update/supplier")
	public ResponseEntity<String> update(@RequestBody Suppliers s) {
		try {
			List<Suppliers> data = service.getById(s.get_id());
			
			if (data==null){
				service.update(s);
				return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Supplier does not exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Intenal error",HttpStatus.BAD_REQUEST);
		}


	}
	
	@DeleteMapping("/delete/supplier/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try {
			List<Suppliers> data = service.getById(id);
			
			if (data==null){
				service.delete(id);
				return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Supplier does not exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Intenal error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/supplier-name")
	public String updateName(@RequestParam String oldName , @RequestParam String newName) {
		service.updateSupplierName(oldName, newName);
		return "Updated Name Successfully";
	}
}
