package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.RawMaterial;

public interface RawMaterialServiceInterface {
	List<RawMaterial> getByUid(String uid);
	List<RawMaterial> getAllData();
	List<RawMaterial> getById(String _id);
	void saveData(RawMaterial r);
	void update(RawMaterial r);
	void delete(String _id);
}
