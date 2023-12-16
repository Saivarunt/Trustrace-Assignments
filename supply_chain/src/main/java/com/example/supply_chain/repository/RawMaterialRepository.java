package com.example.supply_chain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.RawMaterial;

public interface RawMaterialRepository extends MongoRepository<RawMaterial, String>{
	List<RawMaterial> findByMaterialUid(String materialUid);
	List<RawMaterial> findBy_id(String _id);

	void deleteBy_id(String _id);

}
