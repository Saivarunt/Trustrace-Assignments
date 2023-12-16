package com.example.supply_chain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supply_chain.dao.DaoInterface;
import com.example.supply_chain.model.style;
import com.example.supply_chain.repository.StyleRepository;
import com.example.supply_chain.service.StyleServiceInterface;

@Service
public class StyleService implements StyleServiceInterface{
	
	@Autowired
	StyleRepository repo;
	
	@Autowired
	DaoInterface dao;;

	public List<style> getAllStyle(){		
		List<style> list = new ArrayList<>();
		list = repo.findAll();
		return list;		
	}
	
	public List<style> getById(String _id){
		List<style> list = new ArrayList<>();
		list = repo.findBy_id(_id);
		return list;
	}
	
	public List<style> getByUid(String uid){
		return repo.findByStyleUid(uid);
	}
	public style addData(style s) {
		return repo.save(s);
	}
	
	public style updateData(style s) {
		return repo.save(s);
	}
	
	public Boolean deleteData(String _id) {
		return repo.deleteBy_id(_id);
	}
	
	public List<style> getAllData(){
		return dao.getAllData();
		
	}
}

