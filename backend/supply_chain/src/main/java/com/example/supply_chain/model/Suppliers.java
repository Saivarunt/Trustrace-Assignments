package com.example.supply_chain.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suppliers {

	@Id
	private String _id;
	
	private String emailId;
	
	@DocumentReference(collection = "facilities")
	private ArrayList<Facilities> facilities;
	
	private Location location;
	
	private String materialType;
	
	private String rawMaterial;
	
	private String styles;
	
	private String supplierName;
	

	private String supplierUid;
	private String tier;

}
