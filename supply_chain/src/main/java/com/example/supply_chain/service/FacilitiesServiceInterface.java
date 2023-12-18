package com.example.supply_chain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.supply_chain.model.Facilities;

@Service
public interface FacilitiesServiceInterface {
	List<Facilities> getByUid(String uid);
	List<Facilities> getAllData();
	List<Facilities> getById(String _id);
	Facilities saveData(Facilities f);
	Facilities update(Facilities f);
	Boolean delete(String _id);
	void updateFacilityName(String oldName, String newName);
	byte[] getByFileName(String path);
	String uploadFacilitywithFile(Facilities f, MultipartFile file);
	Boolean deleteImage(Facilities f, String fileName);
}
