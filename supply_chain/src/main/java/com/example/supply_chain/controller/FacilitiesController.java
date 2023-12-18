package com.example.supply_chain.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.service.FacilitiesServiceInterface;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/facilities")
public class FacilitiesController {

	@Autowired
	FacilitiesServiceInterface service;
	
	private final String FOLDER_PATH="D:/varun/college/trustrace/code/java/supply_chain/image_files/";

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
			return new ResponseEntity<>(List.of(new Facilities()), HttpStatus.BAD_REQUEST);
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
			return new ResponseEntity<>(new Facilities(),HttpStatus.BAD_REQUEST);
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
			return new ResponseEntity<>(new Facilities(),HttpStatus.BAD_REQUEST);
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

	// With Files
	@GetMapping("/withImage/{facilityUid}/{fileName}")
	public ResponseEntity<byte[]> downloadImageFromFacilitySystem(@PathVariable String facilityUid,@PathVariable String fileName){
		try {
			List<Facilities> data = service.getByUid(facilityUid);
			Facilities f = data.get(0);
			if (f.getImagePath().equals(FOLDER_PATH+fileName)){			
				byte[] imageData=service.getByFileName(FOLDER_PATH+fileName);
				return ResponseEntity.status(HttpStatus.OK)
						.contentType(MediaType.valueOf("image/jpg"))
						.body(imageData);
			}
			else{
				return new ResponseEntity<byte[]>(new byte[1], HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<byte[]>(new byte[1], HttpStatus.BAD_REQUEST);
		}

	}
	@PutMapping("/update/image/{facilityUid}")
	public ResponseEntity<String> uploadImageToFacilitySystem(@PathVariable String facilityUid,@RequestParam("image")MultipartFile file) {
		try {
			List<Facilities> data = service.getByUid(facilityUid);
			if(data.isEmpty()==false){
			String uploadImage = service.uploadFacilitywithFile(data.get(0),file);
			if (uploadImage.equals("Unsuccessful")){
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(uploadImage);
			}
			else{
				return ResponseEntity.status(HttpStatus.OK)
					.body(uploadImage);
			}
			}
			else{
				return new ResponseEntity<String>("No Data Found ", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{facilityUid}/{fileName}")
	public ResponseEntity<Boolean> deleteImageToFacilitySystem(@PathVariable String facilityUid,@PathVariable String fileName) {
		try {
			List<Facilities> data = service.getByUid(facilityUid);
			if(data.isEmpty()==false){
				if(data.get(0).getImagePath().equals(FOLDER_PATH+fileName)){
					Boolean deletedImage = service.deleteImage(data.get(0),fileName);
					if (deletedImage){
						return ResponseEntity.status(HttpStatus.OK)
							.body(deletedImage);
					}
					else{
						return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
							.body(deletedImage);
					}
				}
				else{
					return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
				}
			}
			else{
				return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
	}
}
