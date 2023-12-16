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
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/suppliersbyId/{id}")
	public ResponseEntity<List<Suppliers>> getById(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/save/suppliers")
	public ResponseEntity<Suppliers> insert(@RequestBody Suppliers s) {
		try {
			List<Suppliers> data = service.getByUid(s.getSupplierUid());
			
			if (data.isEmpty()){
				
				return new ResponseEntity<>(service.saveData(s), HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(new Suppliers(), HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}


	}
	
	@PutMapping("/update/suppliers")
	public ResponseEntity<Suppliers> update(@RequestBody Suppliers s) {
		try {
			List<Suppliers> data = service.getByUid(s.getSupplierUid());
			
			if (data.isEmpty()==false){
				
				return new ResponseEntity<>(service.update(s), HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(new Suppliers(), HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}


	}
	
	@DeleteMapping("/delete/suppliers/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
		try {
			List<Suppliers> data = service.getById(id);
			
			if (data.isEmpty()==false){
				return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/supplier-name")
	public String updateName(@RequestParam String oldName , @RequestParam String newName) {
		service.updateSupplierName(oldName, newName);
		return "Updated Name Successfully";
	}
}
