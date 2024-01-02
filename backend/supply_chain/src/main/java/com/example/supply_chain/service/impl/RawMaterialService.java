package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.model.RawMaterial;
import com.example.supply_chain.repository.RawMaterialRepository;
import com.example.supply_chain.service.RawMaterialServiceInterface;

@Service
public class RawMaterialService implements RawMaterialServiceInterface{

	@Autowired
	RawMaterialRepository repo;
	
	public List<RawMaterial> getAllData(){
		List<RawMaterial> list = new ArrayList<>();
		list = repo.findAll();
		return list;
	}
	
	public List<RawMaterial> getById(String _id){
		List<RawMaterial> list = new ArrayList<>();
		list = repo.findBy_id(_id);
		return list;
	}

	public List<RawMaterial> getByUid(String uid){;
		return repo.findByMaterialUid(uid);
	}
	public RawMaterial saveData(RawMaterial r) {
		return repo.save(r);
	}
	
	public RawMaterial update(RawMaterial r) {
		return repo.save(r);
	}
	
	public Boolean delete(String _id) {
		return repo.deleteBy_id(_id);
	}
}
