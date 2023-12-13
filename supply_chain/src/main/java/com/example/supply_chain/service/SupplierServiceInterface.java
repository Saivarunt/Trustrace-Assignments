package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.Suppliers;

public interface SupplierServiceInterface {

	List<Suppliers> getAllData();
	List<Suppliers> getById(String _id);
	void saveData(Suppliers s);
	void update(Suppliers s);
	void delete(String _id);
	void updateSupplierName(String oldName,String newName);
}
