package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.style;

public interface StyleServiceInterface {
	List<style> getByUid(String uid);
	List<style> getAllStyle();
	List<style> getById(String _id);
	style addData(style s);
	style updateData(style s);
	Boolean deleteData(String _id);
	List<style> getAllData();
}
