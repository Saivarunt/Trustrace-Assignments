package com.example.supply_chain.repository;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.supply_chain.model.Facilities;


@Repository

public interface FacilitiesRepository extends MongoRepository<Facilities,String>{

	List<Facilities> findByFacilitiesUid(String facilitiesUid);
	List<Facilities> findBy_id(String _id);

	Boolean deleteBy_id(String _id);

}

