package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.dao.DaoInterface;
import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.repository.FacilitiesRepository;
import com.example.supply_chain.service.FacilitiesServiceInterface;

@Service
public class FacilitiesService implements FacilitiesServiceInterface{

	@Autowired
	FacilitiesRepository repo;
	
	@Autowired
	DaoInterface dao;
	
	public List<Facilities> getAllData(){
		List<Facilities> list = new ArrayList<>();
		list = repo.findAll();
		return list;
		// ArrayList<String> gfg = new ArrayList<String>(Arrays.asList("NONE"));
		// System.out.println(repo);
		// Facilities mock = new Facilities((long) 31345671, gfg,
		// 	"fi global fashion retail",
		// 	"F001234",
		// 	"istanbul,turkey",
		// 	"NONE",
		// 	"12345671",
		// 	"ri textiles LTD"
		//   );
		// repo.insert(mock);
		// System.out.println("done");
		// return repo.findAll();
	}
	
	public List<Facilities> getById(String _id){
		List<Facilities> list = new ArrayList<>();
		list = repo.findBy_id(_id);
		return list;
	}
	
	public List<Facilities> getByUid(String uid){ 
		return repo.findByFacilitiesUid(uid);
	}
	
	public Facilities saveData(Facilities f) {
		return repo.save(f);
	}
	
	public Facilities update(Facilities f) {
		return repo.save(f);
	}
	
	public Boolean delete(String _id) {
		return repo.deleteBy_id(_id);
	}
	
	public void updateFacilityName(String oldName, String newName) {
		dao.facilityNameUpdate(oldName, newName);
	}
}
