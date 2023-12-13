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

import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.service.RawMaterialServiceInterface;

@RestController
@RequestMapping("/rawmaterial")
public class RawMaterialController {

	@Autowired
	RawMaterialServiceInterface service;
	
	@GetMapping("/select/rawmaterial")
	public List<RawMaterial> getAllData(){
		return service.getAllData();
	}
	
	@GetMapping("/select/rawmaterialbyId/{id}")
	public List<RawMaterial> getById(@PathVariable("id") String id){
		return service.getById(id);
		
	}
	
	@PostMapping("/save/rawmaterial")
	public String insert(@RequestBody RawMaterial r) {
		try {
			List<RawMaterial> data = service.getById(r.get_id());
			
			if (data==null){
				service.saveData(r);
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
	
	@PutMapping("/update/rawmaterial")
	public String update(@RequestBody RawMaterial r) {
		try {
			List<RawMaterial> data = service.getById(r.get_id());
			
			if (data==null){
				service.update(r);
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
	
	@DeleteMapping("/delete/rawmaterial/{id}")
	public String delete(@PathVariable("id") String id) {
		try {
			List<RawMaterial> data = service.getById(id);
			
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
}
