package com.example.supply_chain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.style;

public interface StyleRepository extends MongoRepository<style, String>{

	List<style> findByStyleUid(String styleUid);
	List<style> findBy_id(String _id);

	void deleteBy_id(String id);


}
