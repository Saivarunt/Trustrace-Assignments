package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.style;

public interface StyleServiceInterface {

	List<style> getAllStyle();
	List<style> getById(String _id);
	void addData(style s);
	void updateData(style s);
	void deleteData(String _id);
	List<style> getAllData();
}
