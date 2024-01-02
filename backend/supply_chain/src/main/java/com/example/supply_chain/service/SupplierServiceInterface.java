package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.Suppliers;

public interface SupplierServiceInterface {
	List<Suppliers> getByUid(String uid);
	List<Suppliers> getAllData();
	List<Suppliers> getById(String _id);
	Suppliers saveData(Suppliers s);
	Suppliers update(Suppliers s);
	Boolean delete(String _id);
	void updateSupplierName(String oldName,String newName);
}
