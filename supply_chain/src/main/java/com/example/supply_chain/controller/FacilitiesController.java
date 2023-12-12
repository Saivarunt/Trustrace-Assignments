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

import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.service.FacilitiesServiceInterface;

@RestController
@RequestMapping("/facilities")
public class FacilitiesController {

	@Autowired
	FacilitiesServiceInterface service;
	
	@GetMapping("/select/facilities")
	public List<Facilities> getAllFacilities(){
		return service.getAllData();
	}
	
	@GetMapping("/select/facilitiesbyId/{id}")
	public List<Facilities> getById(@PathVariable("id") long id){
		return service.getById(id);
		
	}
	
	@PostMapping("/save/facilities")
	public String insert(@RequestBody Facilities f) {
		List<Facilities> data = service.getById(f.get_id());
		
		if (data==null){
			service.saveData(f);
			return "Inserted Successfully";
		}
		else{
			return "Facility already exists";
		}
	}
	
	@PutMapping("/update/facility")
	public String update(@RequestBody Facilities f) {
		List<Facilities> data = service.getById(f.get_id());
		
		if (data==null){
			service.update(f);
			return "Updated Successfully";
		}
		else{
			return "Facility does not exists";
		}

	}
	
	@DeleteMapping("/delete/facility/{id}")
	public String delete(@PathVariable("id") long id) {
		List<Facilities> data = service.getById(id);
		
		if (data==null){
			service.delete(id);
			return "Deleted Successfully";
		}
		else{
			return "Facility does not exists";
		}


	}
	
	@PutMapping("/update/facility-name")
	public String updateName(String oldName , String newName) {
		service.updateFacilityName(oldName,newName);
		return "Updated Successfully";
	}
}
