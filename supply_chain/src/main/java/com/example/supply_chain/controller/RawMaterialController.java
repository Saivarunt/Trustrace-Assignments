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

import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.service.RawMaterialServiceInterface;

@RestController
@RequestMapping("/rawmaterial")
public class RawMaterialController {

	@Autowired
	RawMaterialServiceInterface service;
	
	@GetMapping("/select/rawmaterial")
	public ResponseEntity<List<RawMaterial>> getAllData(){
		try {
			return new ResponseEntity<List<RawMaterial>>(service.getAllData(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/rawmaterialbyId/{id}")
	public ResponseEntity<List<RawMaterial>> getById(@PathVariable("id") String id){
		try {
			return new ResponseEntity<List<RawMaterial>>(service.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/save/rawmaterial")
	public ResponseEntity<String> insert(@RequestBody RawMaterial r) {
		try {
			List<RawMaterial> data = service.getById(r.get_id());
			
			if (data==null){
				service.saveData(r);
				return new ResponseEntity<String>("Inserted Successfully", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>("Raw Material already exists",HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Intenal error",HttpStatus.BAD_REQUEST);
		}

	}
	
	@PutMapping("/update/rawmaterial")
	public ResponseEntity<String> update(@RequestBody RawMaterial r) {
		try {
			List<RawMaterial> data = service.getById(r.get_id());
			
			if (data==null){
				service.update(r);
				return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Raw Material does not exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Intenal error", HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("/delete/rawmaterial/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		try {
			List<RawMaterial> data = service.getById(id);
			
			if (data==null){
				service.delete(id);
				return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("Raw Material does not exists", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Intenal error", HttpStatus.BAD_REQUEST);
		}

	}
}
