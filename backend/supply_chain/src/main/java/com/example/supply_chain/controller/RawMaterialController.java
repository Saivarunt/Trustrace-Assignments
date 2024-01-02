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
	public ResponseEntity<RawMaterial> insert(@RequestBody RawMaterial r) {
		try {
			List<RawMaterial> data = service.getByUid(r.getMaterialUid());
			
			if (data.isEmpty()){
				
				return new ResponseEntity<>(service.saveData(r), HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(new RawMaterial(),HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}

	}
	
	@PutMapping("/update/rawmaterial")
	public ResponseEntity<RawMaterial> update(@RequestBody RawMaterial r) {
		try {
			List<RawMaterial> data = service.getByUid(r.getMaterialUid());
			
			if (data.isEmpty()==false){
				return new ResponseEntity<>(service.update(r), HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(new RawMaterial(), HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("/delete/rawmaterial/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
		try {
			List<RawMaterial> data = service.getById(id);
			
			if (data.isEmpty()==false){
				return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>(false, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}

	}
}
