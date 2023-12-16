package com.example.supply_chain.service;

import java.util.List;

import com.example.supply_chain.model.RawMaterial;

public interface RawMaterialServiceInterface {
	List<RawMaterial> getByUid(String uid);
	List<RawMaterial> getAllData();
	List<RawMaterial> getById(String _id);
	RawMaterial saveData(RawMaterial r);
	RawMaterial update(RawMaterial r);
	Boolean delete(String _id);
}
