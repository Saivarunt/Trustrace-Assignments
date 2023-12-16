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

import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.service.FacilitiesServiceInterface;

@RestController
@RequestMapping("/facilities")
public class FacilitiesController {

	@Autowired
	FacilitiesServiceInterface service;
	
	@GetMapping("/select/facilities")
	public ResponseEntity<List<Facilities>> getAllFacilities(){
		try {
			return new ResponseEntity<>(service.getAllData(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/select/facilitiesbyId/{id}")
	public ResponseEntity<List<Facilities>> getById(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/save/facilities")
	public ResponseEntity<Facilities> insert(@RequestBody Facilities f) {
		try {
			List<Facilities> data = service.getByUid(f.getFacilitiesUid());
			if (data.isEmpty()){
				
				return new ResponseEntity<>(service.saveData(f),HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(new Facilities(),HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/facilities")
	public ResponseEntity<Facilities> update(@RequestBody Facilities f) {
		try {
			List<Facilities> data = service.getByUid(f.getFacilitiesUid());
			if (data.isEmpty()==false){
				return new ResponseEntity<>(service.update(f),HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(new Facilities(),HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("/delete/facilities/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
		try {
			List<Facilities> data = service.getById(id);
			if (data.isEmpty()==false){
				return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
		}


	}
	
	// @PutMapping("/update/facility-name")
	// public String updateName(String oldName , String newName) {
	// 	service.updateFacilityName(oldName,newName);
	// 	return "Updated Successfully";
	// }
}
