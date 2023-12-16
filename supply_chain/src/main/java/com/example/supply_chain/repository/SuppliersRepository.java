package com.example.supply_chain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.supply_chain.model.Suppliers;

public interface SuppliersRepository extends MongoRepository<Suppliers,String>{
	List<Suppliers> findBySupplierUid(String supplierUid);
	Boolean deleteBy_id(String _id);

	List<Suppliers> findBy_id(String _id);

}
